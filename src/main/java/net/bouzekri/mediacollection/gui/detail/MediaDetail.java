/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.gui.detail;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.bouzekri.mediacollection.exception.MediaImageNotFoundException;
import net.bouzekri.mediacollection.model.Media;

/**
 *
 * @author jobou
 */
public abstract class MediaDetail {

  public abstract void setPanel(JPanel panel);

  public abstract void initComponents();

  public abstract void loadItemForId(Integer id);

  public abstract void detailPaneVisibility(boolean visible);

  public ImageIcon getScaledImage(ImageIcon image) throws MediaImageNotFoundException {
    if (image.getIconWidth() == -1 || image.getIconHeight() == -1) {
      throw new MediaImageNotFoundException(image.toString()+" not found or is not an image");
    }

    Dimension imageSize = new Dimension(image.getIconWidth(), image.getIconHeight());
    Dimension boundary = new Dimension(100, 100);
    Dimension scaledSize = MediaDetail.getScaledDimension(imageSize, boundary);

    BufferedImage resizedImage = new BufferedImage(scaledSize.width, scaledSize.height, 2);
    Graphics2D g = resizedImage.createGraphics();
    g.drawImage(image.getImage(), 0, 0, scaledSize.width, scaledSize.height, null);
    g.dispose();

    return new ImageIcon(resizedImage);
  }

  public static Dimension getScaledDimension(Dimension imageSize, Dimension boundary) {
    int original_width = imageSize.width;
    int original_height = imageSize.height;
    int bound_width = boundary.width;
    int bound_height = boundary.height;
    int new_width = original_width;
    int new_height = original_height;

    // first check if we need to scale width
    if (original_width > bound_width) {
        //scale width to fit
        new_width = bound_width;
        //scale height to maintain aspect ratio
        new_height = (new_width * original_height) / original_width;
    }

    // then check if we need to scale even with the new height
    if (new_height > bound_height) {
        //scale height to fit instead
        new_height = bound_height;
        //scale width to maintain aspect ratio
        new_width = (new_height * original_width) / original_height;
    }

    return new Dimension(new_width, new_height);
  }
}
