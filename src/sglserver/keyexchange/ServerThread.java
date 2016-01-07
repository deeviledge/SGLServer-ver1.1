/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sglserver.keyexchange;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author tatoo
 */
public class ServerThread extends Thread{
    ServerSocket serversoc;
    Socket socket;
    
    public ServerThread(String ip,int roundport){
        try{
            System.out.println("▽▽▽▽▽▽▽▽▽サーバソケットを生成するよ。ポート番号は"+roundport+"だよ▽▽▽▽▽▽▽▽▽▽▽▽");
            socket = new Socket( ip , roundport );
            System.out.println("SGLクライアントIP="+ip+"："+socket.getInetAddress()+"との接続完了");//接続先アドレスを返して表示
            socket.close();
            System.out.println("△△△△△△△△△接続してソケット閉じるとこまでいったよ。やった～！△△△△△△△△△△△△");
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            System.out.println("サーバーソケット生成中になんかあった");
        }
    }
    /*
    public void SavePK(){
    
    
    }
    
    public void XmlFlg(){
        
    }
    */
}