package cn.sxt.game;
 
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
//����һ���޲εĹ��췽��
//ImageIO��read����
 //�ص㣺public static Image getImage
//String������ʹ��
//��ʹ������ʹ��Ϊ��������ѵ㡣
public class GameUtil {
    // ��������ý�������˽�л���
    private GameUtil() {
    } 
 
    /**
     * ����ָ��·���ļ���ͼƬ����
     * @param path
     * @return
     */
    public static Image getImage(String path) {//String������ʹ��
        BufferedImage bi = null;
        try {
            URL u = GameUtil.class.getClassLoader().getResource(path);//���ⷽ����ʹ�ã����������ѵ㡣
            bi = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }
}