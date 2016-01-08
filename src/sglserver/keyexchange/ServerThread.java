/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sglserver.keyexchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author tatoo
 */
public class ServerThread extends Thread{
    ServerSocket serversoc;
    Socket socket;
    String line=null;
    
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
    public String ReceivePublicKey(){
        try{
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //公開鍵を受信
            line = in.readLine();
            System.out.println("公開鍵を受信："+line);
            in.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error:公開鍵の受信処理中になんかあった");
        }
        return line;
    }
    public void SendPublicKey(String pk){
        try{
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String input = "pk:";
            input += ""+pk;
            out.println(input);
            out.close();
        }catch(Exception e){
            System.out.println("公開鍵の送信中になんかあった");
        }
    }
    /*
    public void SavePublicKey(){
        ここではdyanmicpeerinformation.javaのように
        RoundInformationXml　rix=new RoundInformationXml();
        rix.SavePublickey();
        とういうふうに書くとよい。
        よってsglserver.keyexchangeフォルダ内に新たにRoundInformation.javaのクラスを作成
        さらにsglserver.roundinfromation.xml_filesフォルダを作成してフォルダ内に    RoundInformation.xmlを作成するとよい
        RoundInformationXml内ではSavePublicKeyメソッドをsynchronizedにして処理の競合を避けるようにする
    }
    
    public void SavePK(){
    
    
    }
    
    public void XmlFlg(){
        
    }
    */
}