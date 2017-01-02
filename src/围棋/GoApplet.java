package 围棋;

/**
 * Created by h on 16-12-21.
 */
/*******************GoApplet**************************/
import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;//引用相应的包

public class GoApplet extends Applet
{
    public void init()//创建对象
    {
        new MainWindow().show();//主窗口

    }

}