package com.spriteX;

import javax.microedition.lcdui.*;
import java.io.*;

//import com.nokia.mid.ui.*;

public class SpriteX {
  public static final int TRANS_NONE = 0;
  public static final int TRANS_ROT90 = 5;
  public static final int TRANS_ROT180 = 3;
  public static final int TRANS_ROT270 = 6;
  public static final int TRANS_MIRROR = 2;
  public static final int TRANS_MIRROR_ROT90 = 7;
  public static final int TRANS_MIRROR_ROT180 = 1;
  public static final int TRANS_MIRROR_ROT270 = 4;
  int[][] actionData;
  int[][] frameData;
  int[][] tileData;
  int actionIndex;
  int sequenceIndex;
  Image image;
  int x;
  int y;
  boolean visible;

  public SpriteX(String spxName, Image image) {
    try {
      InputStream is = this.getClass().getResourceAsStream(spxName);
      DataInputStream data = new DataInputStream(is);
      int header;
      int actionCount;
      int sequenceLength;
      int frameCount;
      int collisionCount;
      int tileCount;
      int i, j, offset;

      //check spx format
      header = data.readInt();
      if (header != 0x53505231) {
        throw new Exception("invalid file format\n");
      }
      else {
        //read action
        actionCount = data.readInt();
        actionData = new int[actionCount][];
        for (i = 0; i < actionCount; i++) {
          sequenceLength = data.readInt();
          actionData[i] = new int[sequenceLength];
          for (j = 0; j < sequenceLength; j++) {
            actionData[i][j] = data.readInt();
          }
        }

        //read frame
        frameCount = data.readInt();
        frameData = new int[frameCount][];
        for (i = 0; i < frameCount; i++) {
          tileCount = data.readInt();
          collisionCount = data.readInt();
          frameData[i] = new int[tileCount * 4 + collisionCount * 4 + 2];
          //struct
          //array[0] tile count
          //arrat[1] collision count
          //...
          //array[2] tile index
          //array[3] tile x
          //array[4] tile y
          //array[5] tile transform
          //...
          //array[6] collision x
          //array[7] collision y
          //array[8] collision width
          //array[9] collision height
          //...
          frameData[i][0] = tileCount;
          frameData[i][1] = collisionCount;
          offset = 2;
          for (j = 0; j < tileCount; j++) {
            frameData[i][0 + offset] = data.readInt(); //index
            frameData[i][1 + offset] = data.readInt(); //x
            frameData[i][2 + offset] = data.readInt(); //y
            frameData[i][3 + offset] = data.readInt(); //transform
            offset += 4;
          }

          for (j = 0; j < collisionCount; j++) {
            frameData[i][0 + offset] = data.readInt(); //collision x
            frameData[i][1 + offset] = data.readInt(); //collision y
            frameData[i][2 + offset] = data.readInt(); //collision width
            frameData[i][3 + offset] = data.readInt(); //collision height
            offset += 4;
          }
        }

        //read tile
        tileCount = data.readInt();
        tileData = new int[tileCount][4];
        //struct
        //...
        //array[0] tile x
        //array[1] tile y
        //array[2] tile width
        //array[3] tile height
        //..
        for (i = 0; i < tileCount; i++) {
          tileData[i][0] = data.readInt();
          tileData[i][1] = data.readInt();
          tileData[i][2] = data.readInt();
          tileData[i][3] = data.readInt();
        }
      }

      setImage(image);
      //load complete
      visible = true;
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public SpriteX(String spxName, String imageName) {
    try {
      InputStream is = this.getClass().getResourceAsStream(spxName);
      DataInputStream data = new DataInputStream(is);
      int header;
      int actionCount;
      int sequenceLength;
      int frameCount;
      int tileCount;
      int collisionCount;
      int i, j, offset;

      //check spx format
      header = data.readInt();
      if (header != 0x53505258) {
        throw new Exception("invalid SpriteX format\n");
      }
      else {
        //read action
        actionCount = data.readInt();
        actionData = new int[actionCount][];
        for (i = 0; i < actionCount; i++) {
          sequenceLength = data.readInt();
          actionData[i] = new int[sequenceLength];
          for (j = 0; j < sequenceLength; j++) {
            actionData[i][j] = data.readInt();
          }
        }

        //read frame
        frameCount = data.readInt();
        frameData = new int[frameCount][];
        for (i = 0; i < frameCount; i++) {
          tileCount = data.readInt();
          collisionCount = data.readInt();
          frameData[i] = new int[tileCount * 4 + collisionCount * 4 + 2];
          //struct
          //array[0] tile count
          //arrat[1] collision count
          //...
          //array[2] tile index
          //array[3] tile x
          //array[4] tile y
          //array[5] tile transform
          //...
          //array[6] collision x
          //array[7] collision y
          //array[8] collision width
          //array[9] collision height
          //...
          frameData[i][0] = tileCount;
          frameData[i][1] = collisionCount;
          offset = 2;
          for (j = 0; j < tileCount; j++) {
            frameData[i][0 + offset] = data.readInt(); //index
            frameData[i][1 + offset] = data.readInt(); //x
            frameData[i][2 + offset] = data.readInt(); //y
            frameData[i][3 + offset] = data.readInt(); //transform
            offset += 4;
          }

          for (j = 0; j < collisionCount; j++) {
            frameData[i][0 + offset] = data.readInt(); //collision x
            frameData[i][1 + offset] = data.readInt(); //collision y
            frameData[i][2 + offset] = data.readInt(); //collision width
            frameData[i][3 + offset] = data.readInt(); //collision height
            offset += 4;
          }
        }

        //read tile
        tileCount = data.readInt();
        tileData = new int[tileCount][4];
        //struct
        //...
        //array[0] tile x
        //array[1] tile y
        //array[2] tile width
        //array[3] tile height
        //..
        for (i = 0; i < tileCount; i++) {
          tileData[i][0] = data.readInt();
          tileData[i][1] = data.readInt();
          tileData[i][2] = data.readInt();
          tileData[i][3] = data.readInt();
        }
      }
      setImage(Image.createImage(imageName));
      //load complete
      visible = true;
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public SpriteX(SpriteX spx) {
    //init vars
    int i, count, length;
    actionData = new int[spx.actionData.length][];
    frameData = new int[spx.frameData.length][];
    tileData = new int[spx.tileData.length][];
    //copy action
    count = spx.actionData.length;
    for (i = 0; i < count; i++) {
      length = spx.actionData[i].length;
      actionData[i] = new int[length];
      System.arraycopy(spx.actionData[i], 0, actionData[i], 0, length);
    }
    //copy frame
    count = spx.frameData.length;
    for (i = 0; i < count; i++) {
      length = spx.frameData[i].length;
      frameData[i] = new int[length];
      System.arraycopy(spx.frameData[i], 0, frameData[i], 0, length);
    }
    //copy tile
    count = spx.tileData.length;
    for (i = 0; i < count; i++) {
      length = spx.tileData[i].length;
      tileData[i] = new int[length];
      System.arraycopy(spx.tileData[i], 0, tileData[i], 0, length);
    }
    //copy complete
    actionIndex = spx.actionIndex;
    sequenceIndex = spx.sequenceIndex;
    image = spx.image;
    x = spx.x;
    y = spx.y;
    visible = spx.visible;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public Image getImage() {
    return image;
  }

  public void setAction(int actionIndex) {
    if (actionIndex < 0 || actionIndex >= actionData.length) {
      throw new IndexOutOfBoundsException();
    }
    this.actionIndex = actionIndex;
  }

  public final int getAction() {
    return actionIndex;
  }

  public void setFrame(int sequenceIndex) {
    if (sequenceIndex < 0 || sequenceIndex >= actionData[actionIndex][0]) {
      throw new IndexOutOfBoundsException();
    }
    this.sequenceIndex = sequenceIndex;
  }

  public final int getFrame() {
    return sequenceIndex;
  }

  public void nextFrame() {
    sequenceIndex = (sequenceIndex + 1) % actionData[actionIndex].length;
  }

  public void prevFrame() {
    if (sequenceIndex == 0) {
      sequenceIndex = actionData[actionIndex].length - 1;
    }
    else {
      sequenceIndex--;
    }
  }

  public int getSequenceLength() {
    return actionData[actionIndex].length;
  }

  public int getCollidesX(int index) {
    int frameIndex = actionData[actionIndex][sequenceIndex];
    if (index < 0 || index >= frameData[frameIndex][1]) {
      throw new ArrayIndexOutOfBoundsException();
    }
    else {
      int offset = 2 + frameData[frameIndex][0] * 4 + index * 4;
      return frameData[frameIndex][offset] + x;
    }
  }

  public int getCollidesY(int index) {
    int frameIndex = actionData[actionIndex][sequenceIndex];
    if (index < 0 || index >= frameData[frameIndex][1]) {
      throw new ArrayIndexOutOfBoundsException();
    }
    else {
      int offset = 2 + frameData[frameIndex][0] * 4 + index * 4 + 1;
      return frameData[frameIndex][offset] + y;
    }
  }

  public int getCollidesWidth(int index) {
    int frameIndex = actionData[actionIndex][sequenceIndex];
    if (index < 0 || index >= frameData[frameIndex][1]) {
      throw new ArrayIndexOutOfBoundsException();
    }
    else {
      int offset = 2 + frameData[frameIndex][0] * 4 + index * 4 + 2;
      return frameData[frameIndex][offset];
    }
  }

  public int getCollidesHeight(int index) {
    int frameIndex = actionData[actionIndex][sequenceIndex];
    if (index < 0 || index >= frameData[frameIndex][1]) {
      throw new ArrayIndexOutOfBoundsException();
    }
    else {
      int offset = 2 + frameData[frameIndex][0] * 4 + index * 4 + 3;
      return frameData[frameIndex][offset];
    }
  }

  public boolean collidesWith(SpriteX s, int collidesIndex1, int collidesIndex2,
                              int type) {
    if (! (s.visible && this.visible)) {
      return false;
    }

    if (type == 0) {
      return intersectRect(s.getCollidesX(collidesIndex2),
                           s.getCollidesY(collidesIndex2),
                           s.getCollidesWidth(collidesIndex2),
                           s.getCollidesHeight(collidesIndex2),
                           this.getCollidesX(collidesIndex1),
                           this.getCollidesY(collidesIndex1),
                           this.getCollidesWidth(collidesIndex1),
                           this.getCollidesHeight(collidesIndex1));
    }
    else if (type == 1) {
      return inRect(s.getCollidesX(collidesIndex2),
                    s.getCollidesY(collidesIndex2),
                    s.getCollidesWidth(collidesIndex2),
                    s.getCollidesHeight(collidesIndex2),
                    this.getCollidesX(collidesIndex1),
                    this.getCollidesY(collidesIndex1),
                    this.getCollidesWidth(collidesIndex1),
                    this.getCollidesHeight(collidesIndex1));

    }
    else {
      throw new ArithmeticException();
    }
  }

  public boolean collidesWith(Image image, int x, int y, int collidesIndex,
                              int type) {
    if (!this.visible) {
      return false;
    }
    if (type == 0) {
      return intersectRect(x, y, image.getWidth(), image.getHeight(),
                           this.getCollidesX(collidesIndex),
                           this.getCollidesY(collidesIndex),
                           this.getCollidesWidth(collidesIndex),
                           this.getCollidesHeight(collidesIndex));
    }
    else if (type == 1) {
      return inRect(x, y, image.getWidth(), image.getHeight(),
                    this.getCollidesX(collidesIndex),
                    this.getCollidesY(collidesIndex),
                    this.getCollidesWidth(collidesIndex),
                    this.getCollidesHeight(collidesIndex));

    }
    else {
      throw new ArithmeticException();
    }
  }

  public boolean collidesWith(int x, int y, int width, int height,
                              int collidesIndex, int type) {
    if (!this.visible) {
      return false;
    }
    if (type == 0) {
      return intersectRect(x, y,
                           width, height,
                           this.getCollidesX(collidesIndex),
                           this.getCollidesY(collidesIndex),
                           this.getCollidesWidth(collidesIndex),
                           this.getCollidesHeight(collidesIndex));
    }
    else if (type == 1) {
      return inRect(x, y,
                    width, height,
                    this.getCollidesX(collidesIndex),
                    this.getCollidesY(collidesIndex),
                    this.getCollidesWidth(collidesIndex),
                    this.getCollidesHeight(collidesIndex));

    }
    else {
      throw new ArithmeticException();
    }
  }

  public boolean collidesWith(SpriteX s) {
    if (! (s.visible && this.visible)) {
      return false;
    }

    int frameIndex = actionData[actionIndex][sequenceIndex];
    if (frameData[frameIndex][1] == 0) {
      return false;
    }

    frameIndex = s.actionData[actionIndex][sequenceIndex];
    if (s.frameData[frameIndex][1] == 0) {
      return false;
    }

    return intersectRect(s.getCollidesX(0), s.getCollidesY(0),
                         s.getCollidesWidth(0), s.getCollidesHeight(0),
                         this.getCollidesX(0), this.getCollidesY(0),
                         this.getCollidesWidth(0), this.getCollidesHeight(0));
  }

  public boolean collidesWith(Image image, int x, int y) {
    if (!this.visible) {
      return false;
    }

    int frameIndex = actionData[actionIndex][sequenceIndex];
    if (frameData[frameIndex][1] == 0) {
      return false;
    }

    return intersectRect(x, y, image.getWidth(), image.getHeight(),
                         this.getCollidesX(0), this.getCollidesY(0),
                         this.getCollidesWidth(0), this.getCollidesHeight(0));
  }

  public boolean collidesWith(int x, int y, int width, int height) {
    if (!this.visible) {
      return false;
    }

    int frameIndex = actionData[actionIndex][sequenceIndex];
    if (frameData[frameIndex][1] == 0) {
      return false;
    }

    return intersectRect(x, y, width, height, this.getCollidesX(0),
                         this.getCollidesY(0), this.getCollidesWidth(0),
                         this.getCollidesHeight(0));
  }

  public static boolean intersectRect(int x1, int y1, int width1, int height1,
                                      int x2, int y2, int width2, int height2) {
    if (y2 + height2 < y1 || y2 > y1 + height1 || x2 + width2 < x1 ||
        x2 > x1 + width1) {
      return false;
    }
    else {
      return true;
    }
  }

  public static boolean inRect(int x1, int y1, int width1, int height1,
                               int x2, int y2, int width2, int height2) {
    if (y2 >= y1 &&
        y2 + height2 <= y1 + height1 &&
        x2 >= x1 &&
        x2 + width2 <= x1 + width1) {
      return true;
    }

    return false;
  }

  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public boolean isVisible() {
    return visible;
  }

  public void paint(Graphics g) {
    if (g == null) {
      throw new NullPointerException();
    }
    if (visible) {
      int tileIndex; //tile index
      int dx; //tile dest x
      int dy; //tile dest y
      int transform; //tile transform
      int tx; //tile x
      int ty; //tile y
      int tw; //tile width
      int th; //tile height
      int frameIndex = actionData[actionIndex][sequenceIndex];
      int tileCount = frameData[frameIndex][0];
      int offset = 2; //tile data offset
      for (int i = 0; i < tileCount; i++) {
        tileIndex = frameData[frameIndex][0 + offset];
        dx = frameData[frameIndex][1 + offset] + x;
        dy = frameData[frameIndex][2 + offset] + y;
        transform = frameData[frameIndex][3 + offset];
        tx = tileData[tileIndex][0];
        ty = tileData[tileIndex][1];
        tw = tileData[tileIndex][2];
        th = tileData[tileIndex][3];
        drawRegion(g, image, tx, ty, tw, th, transform, dx, dy, 0);
        offset += 4;
      }
    }
  }

  public static void drawRegionMIDP1(Graphics g, Image src, int x_src,
                                     int y_src,
                                     int width, int height, int transform,
                                     int x_dest,
                                     int y_dest, int anchor) {
    if (g == null) {
      throw new NullPointerException();
    }

    if (src == null) {
      throw new NullPointerException();
    }

    if (anchor != 0) {
      boolean flag = false;
      flag = anchor > 0 && anchor < 128 && (anchor & 64) == 0;
      if (flag) {
        int h = anchor & 0x72;
        flag = h != 0 && (h & h - 1) == 0;
      }
      if (flag) {
        int v = anchor & 0xd;
        flag = v != 0 && (v & v - 1) == 0;
      }
      throw new IllegalArgumentException();
    }

    if (transform < 0 || transform > 7) {
      throw new IllegalArgumentException();
    }

    if (width < 0 || height < 0 || x_src < 0 || y_src < 0 ||
        x_src + width > src.getWidth() || y_src + height > src.getHeight()) {
      throw new IllegalArgumentException();
    }

    int clip_x = g.getClipX();
    int clip_y = g.getClipY();
    int clip_w = g.getClipWidth();
    int clip_h = g.getClipHeight();

    if ( (0x00000004 & transform) == 0) {
      if (anchor != 0) {
        if ( (anchor & g.BOTTOM) != 0) {
          y_dest -= height;
        }
        if ( (anchor & g.RIGHT) != 0) {
          x_dest -= width;
        }
        if ( (anchor & g.HCENTER) != 0) {
          x_dest -= width / 2;
        }
        if ( (anchor & g.VCENTER) != 0) {
          y_dest -= height / 2;
        }
      }

      g.clipRect(x_dest, y_dest, width, height);
    }
    else {

      if (anchor != 0) {
        if ( (anchor & g.BOTTOM) != 0) {
          y_dest -= width;
        }
        if ( (anchor & g.RIGHT) != 0) {
          x_dest -= height;
        }
        if ( (anchor & g.HCENTER) != 0) {
          x_dest -= height / 2;
        }
        if ( (anchor & g.VCENTER) != 0) {
          y_dest -= width / 2;
        }
      }

      g.clipRect(x_dest, y_dest, height, width);
    }

    int x_offset = 0;
    int y_offset = 0;

    int srcWidth = src.getWidth();
    int srcHeight = src.getHeight();

    switch (transform) {
      case TRANS_NONE:
        g.drawImage(src, x_dest - x_src, y_dest - y_src, g.LEFT | g.TOP);
        g.setClip(clip_x, clip_y, clip_w, clip_h);
        return;
      case TRANS_ROT90:
        x_offset = srcHeight - (y_src + height);
        y_offset = x_src;
        break;
      case TRANS_ROT180:
        x_offset = srcWidth - (x_src + width);
        y_offset = srcHeight - (y_src + height);
        break;
      case TRANS_ROT270:
        x_offset = y_src;
        y_offset = srcWidth - (x_src + width);
        break;
      case TRANS_MIRROR:
        x_offset = srcWidth - (x_src + width);
        y_offset = y_src;
        break;
      case TRANS_MIRROR_ROT90:
        x_offset = srcHeight - (y_src + height);
        y_offset = srcWidth - (x_src + width);
        break;
      case TRANS_MIRROR_ROT180:
        x_offset = x_src;
        y_offset = srcHeight - (y_src + height);
        break;
      case TRANS_MIRROR_ROT270:
        x_offset = y_src;
        y_offset = x_src;
        break;
    }

    x_dest -= x_offset;
    y_dest -= y_offset;

    int clipX1 = g.getClipX();
    int clipY1 = g.getClipY();
    int clipX2 = g.getClipX() + g.getClipWidth();
    int clipY2 = g.getClipY() + g.getClipHeight();

    if ( (0x00000004 & transform) != 0) {
      int temp = srcWidth;
      srcWidth = srcHeight;
      srcHeight = temp;
    }

    int src_start_x = Math.max(0, clipX1 - x_dest);
    int src_start_y = Math.max(0, clipY1 - y_dest);

    int dest_start_x = Math.max(clipX1, x_dest);
    int dest_start_y = Math.max(clipY1, y_dest);

    int dest_right = x_dest + srcWidth;
    int dest_bottom = y_dest + srcHeight;

    int copy_width = srcWidth - src_start_x;
    int copy_height = srcHeight - src_start_y;

    copy_width -= Math.max(0, dest_right - clipX2);
    copy_height -= Math.max(0, dest_bottom - clipY2);

    int px = 0;
    int py = 0;

    for (int i = 0; i < copy_height; i++) {
      for (int j = 0; j < copy_width; j++) {
        switch (transform) {
          case TRANS_ROT90:
            px = src_start_y + i;
            py = (srcWidth - 1 - j) - src_start_x;
            break;
          case TRANS_ROT180:
            px = (srcWidth - 1 - j) - src_start_x;
            py = (srcHeight - 1 - i) - src_start_y;
            break;
          case TRANS_ROT270:
            px = (srcHeight - 1 - i) - src_start_y;
            py = src_start_x + j;
            break;
          case TRANS_MIRROR:
            px = (srcWidth - 1 - j) - src_start_x;
            py = src_start_y + i;
            break;
          case TRANS_MIRROR_ROT90:
            px = (srcHeight - 1 - i) - src_start_y;
            py = (srcWidth - 1 - j) - src_start_x;
            break;
          case TRANS_MIRROR_ROT180:
            px = src_start_x + j;
            py = (srcHeight - 1 - i) - src_start_y;
            break;
          case TRANS_MIRROR_ROT270:
            px = src_start_y + i;
            py = src_start_x + j;
            break;
        }

        g.setClip(dest_start_x + j, dest_start_y + i, 1, 1);
        g.drawImage(src, dest_start_x + j - px, dest_start_y + i - py,
                    g.LEFT | g.TOP);
      }
    }

    g.setClip(clip_x, clip_y, clip_w, clip_h);
  }

//  public static void drawRegionNokia(Graphics g, Image src, int x_src,
//                                     int y_src,
//                                     int width, int height, int transform,
//                                     int x_dest,
//                                     int y_dest, int anchor) {
//    if (g == null) {
//      throw new NullPointerException();
//    }
//
//    if (src == null) {
//      throw new NullPointerException();
//    }
//
//    if (anchor != 0) {
//      boolean flag = false;
//      flag = anchor > 0 && anchor < 128 && (anchor & 64) == 0;
//      if (flag) {
//        int h = anchor & 0x72;
//        flag = h != 0 && (h & h - 1) == 0;
//      }
//      if (flag) {
//        int v = anchor & 0xd;
//        flag = v != 0 && (v & v - 1) == 0;
//      }
//      throw new IllegalArgumentException();
//    }
//
//    if (transform < 0 || transform > 7) {
//      throw new IllegalArgumentException();
//    }
//
//    if (width < 0 || height < 0 || x_src < 0 || y_src < 0 ||
//        x_src + width > src.getWidth() || y_src + height > src.getHeight()) {
//      throw new IllegalArgumentException();
//    }
//
//    if ( (0x00000004 & transform) != 0) {
//      if (anchor != 0) {
//        if ( (anchor & g.BOTTOM) != 0) {
//          y_dest -= width;
//        }
//        if ( (anchor & g.RIGHT) != 0) {
//          x_dest -= height;
//        }
//        if ( (anchor & g.HCENTER) != 0) {
//          x_dest -= height / 2;
//        }
//        if ( (anchor & g.VCENTER) != 0) {
//          y_dest -= width / 2;
//        }
//      }
//
//      g.setClip(x_dest, y_dest, height, width);
//    }
//    else {
//      if (anchor != 0) {
//        if ( (anchor & g.BOTTOM) != 0) {
//          y_dest -= height;
//        }
//        if ( (anchor & g.RIGHT) != 0) {
//          x_dest -= width;
//        }
//        if ( (anchor & g.HCENTER) != 0) {
//          x_dest -= width / 2;
//        }
//        if ( (anchor & g.VCENTER) != 0) {
//          y_dest -= height / 2;
//        }
//      }
//
//      g.setClip(x_dest, y_dest, width, height);
//    }
//
//    int manipulation = 0;
//    int x_offset = 0;
//    int y_offset = 0;
//
//    switch (transform) {
//      case TRANS_NONE:
//        g.drawImage(src, x_dest - x_src, y_dest - y_src, 0);
//        return;
//      case TRANS_ROT90:
//        manipulation = DirectGraphics.ROTATE_270;
//        x_offset = src.getHeight() - (y_src + height);
//        y_offset = x_src;
//        break;
//      case TRANS_ROT180:
//        manipulation = DirectGraphics.ROTATE_180;
//        x_offset = src.getWidth() - (x_src + width);
//        y_offset = src.getHeight() - (y_src + height);
//        break;
//      case TRANS_ROT270:
//        manipulation = DirectGraphics.ROTATE_90;
//        x_offset = y_src;
//        y_offset = src.getWidth() - (x_src + width);
//        break;
//      case TRANS_MIRROR:
//        manipulation = DirectGraphics.FLIP_HORIZONTAL;
//        x_offset = src.getWidth() - (x_src + width);
//        y_offset = y_src;
//        break;
//      case TRANS_MIRROR_ROT90:
//        manipulation = DirectGraphics.FLIP_HORIZONTAL |
//            DirectGraphics.ROTATE_90;
//        x_offset = src.getHeight() - (y_src + height);
//        y_offset = src.getWidth() - (x_src + width);
//        break;
//      case TRANS_MIRROR_ROT180:
//        manipulation = DirectGraphics.FLIP_HORIZONTAL |
//            DirectGraphics.ROTATE_180;
//        x_offset = x_src;
//        y_offset = src.getHeight() - (y_src + height);
//        break;
//      case TRANS_MIRROR_ROT270:
//        manipulation = DirectGraphics.FLIP_HORIZONTAL |
//            DirectGraphics.ROTATE_270;
//        x_offset = y_src;
//        y_offset = x_src;
//        break;
//    }
//
//    DirectGraphics dg = DirectUtils.getDirectGraphics(g);
//    dg.drawImage(src, x_dest - x_offset, y_dest - y_offset, 0, manipulation);
//  }

  public static void drawRegion(Graphics g, Image src, int x_src, int y_src,
                                int width, int height, int transform,
                                int x_dest,
                                int y_dest, int anchor) {

//    //MIDP2.0
//    g.drawRegion(src, x_src, y_src, width, height, transform, x_dest, y_dest,
//                 anchor);
//    //MIDP1.0
    drawRegionMIDP1(g, src, x_src, y_src, width, height, transform, x_dest,
                    y_dest,
                    anchor);
    //MIDP nokia
//    drawRegionNokia(g, src, x_src, y_src, width, height, transform, x_dest,
//                    y_dest, anchor);
  }

}
