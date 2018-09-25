package utility;

/**
 * @author M1047073
 *@date 31/08/2018
 *@purpose this class is the ui class for the progressbar
 */

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class IllusionProgressBarUI extends BasicProgressBarUI {
    private int numFrames = 200;
    public enum AnimationDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }
    private AnimationDirection direction = AnimationDirection.RIGHT_TO_LEFT;

    public IllusionProgressBarUI() {
        startAnimationTimer();
    }
    private BufferedImage barImage = createRippleImage(Color.green.darker(), Color.green);
    protected BufferedImage createRippleImage(Color darkColor, Color lightColor) {
        int width = 40;
        int height = 40;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();

        GradientPaint darkToLight = new GradientPaint(new Point2D.Double(0,0), darkColor, new Point2D.Double(width/2, 0), lightColor);
        GradientPaint lightToDark = new GradientPaint(new Point2D.Double(width/2,0), lightColor, new Point2D.Double(width, 0), darkColor);
        g2.setPaint(darkToLight);
        g2.fillRect(0, 0, width/2, height);
        g2.setPaint(lightToDark);
        g2.fillRect(width/2, 0, width/2, height);
        return image;
    }

    public AnimationDirection getDirection() {
        return direction;
    }

    public void setDirection(AnimationDirection direction) {
        this.direction = direction;
    }


    /**
     * Used by an internal timer to increment the state of the animation.
     *
     * This code is copied from the original implementation, but with our own
     * numFrames variable (the standard numFrames is private in ProgressBarUI)
     */
    @Override
    protected void incrementAnimationIndex() {
        int newValue = getAnimationIndex() + 1;
        if (newValue < numFrames) {
            setAnimationIndex(newValue);
        } else {
            setAnimationIndex(0);
        }
    }


    /**
     * This method is called when the progress bar is in determinate mode (e.g.
     * the progress bar is reflecting 50% completion) and the bar needs to be
     * redrawn.
     *
     * In order to achieve an effect of movement, we take the gradient image
     * we created (@see barImage), and tile it across the length of the filled
     * in area of the progress bar.  At each frame, this method is called, and the
     * currentFrameIndex variable is changed.  We use this value to move the
     * center of the tiled images to the right or to the left depending on which
     * direction or animation is moving.
     *
     *
     * @param g the graphics context onto which to draw the determinate progress bar
     * @param c the component
     */
    @Override
    protected void paintDeterminate(Graphics g, JComponent c) {
        // We are only going to deal with horizontal painting
        if (progressBar.getOrientation() != JProgressBar.HORIZONTAL) {
            super.paintDeterminate(g, c);
            return;
        }

        /*
         Copied from the BasicProgressBar code - calculates the actual dimensions of
         the progress bar area, discounting the insets etc
        */
        Insets b = progressBar.getInsets(); // area for border
        int barRectWidth = progressBar.getWidth() - (b.right + b.left);
        int barRectHeight = progressBar.getHeight() - (b.top + b.bottom);

        if (barRectWidth <= 0 || barRectHeight <= 0) {
            return;
        }

        // amount of progress to draw; measured in pixels
        int amountFull = getAmountFull(b, barRectWidth, barRectHeight);


        // Make sure we only draw in the region of the progress bar.  This allows
        // us to be sloppy with our drawing (which is impossible to avoid when
        // dealing with the drawImage commands) and yet still avoid bad artifacts
        g.setClip(b.left, b.top, amountFull, barRectHeight);


        // Here we calculate a pixel offset by which to shift all of our tiled images.
        // If we're moving right to left, then we offset by a decreasing amount each
        // tick.  If we're moving left to right, we do the opposite.
        int offset = 0;
        if (direction == AnimationDirection.RIGHT_TO_LEFT) {
            offset = (int) (map(getAnimationIndex(), 0, numFrames, barImage.getWidth(), 0));
        }
        else {
            offset = (int) (map(getAnimationIndex(), 0, numFrames, 0, barImage.getWidth()));
        }

        // How many repetitions of the image need to be drawn to ensure that
        // a full progress bar has no gaps in the image?
        int numRepetitions = progressBar.getWidth() / barImage.getWidth();
        // ensure both sides have full coverage just to be safe
        numRepetitions += 2;

        for (int i = 0; i < numRepetitions; i++) {
            // The first image we want drawn to the left, even offscreen if
            // necessary.
            int xOffset = (i - 1) * barImage.getWidth() + offset;
            g.drawImage(barImage, xOffset, 0, null);
        }
    }

    /**
     * Map a value in one range to a value in a different range. See
     * <a href="http://developmentality.wordpress.com/2009/12/15/useful-utility-functions-0-of-n/">a blog post</a>
     * I wrote about the subject.
     * @param value The incoming value to be converted
     * @param low1  Lower bound of the value's current range
     * @param high1 Upper bound of the value's current range
     * @param low2  Lower bound of the value's target range
     * @param high2 Upper bound of the value's target range
     */
    public static double map(double value, double low1, double high1, double low2, double high2) {

        double diff = value - low1;
        double proportion = diff / (high1 - low1);

        return lerp(low2, high2, proportion);
    }

    /** Linearly interpolate between two values */
    public static double lerp(double value1, double value2, double amt) {
        return ((value2 - value1) * amt) + value1;
    }

    /**
     * @param args the command line arguments
     */
    
}
