package cn.sxt.game;
 
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
//定义一个无参的构造方法
//ImageIO的read方法
 //重点：public static Image getImage
//String方法的使用
//特使方法的使用为本程序的难点。
public class GameUtil {
    // 工具类最好将构造器私有化。
    private GameUtil() {
    } 
 
    /**
     * 返回指定路径文件的图片对象
     * @param path
     * @return
     */
    public static Image getImage(String path) {//String方法的使用
        BufferedImage bi = null;
        try {
            URL u = GameUtil.class.getClassLoader().getResource(path);//特殊方法的使用；本程序疑难点。
            bi = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }
}