/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sglserver.keyexchange;

import java.net.ServerSocket;
import sglserver.dynamicpeerinformation.DynamicPeerInformation;

/**
 *
 * @author tatoo
 */
public class ThreadController {
    
    ServerSocket serversoc;
    String ip1,ip2;
    int roundport1,roundport2;
    public ThreadController(String name1,String name2){
        
        try{
            DynamicPeerInformation dpinfo = new DynamicPeerInformation();
            //↓usernameからIDを取得して5と文字連結させてint型に変換
            roundport1=Integer.parseInt("5"+dpinfo.getID(name1));
            roundport2=Integer.parseInt("5"+dpinfo.getID(name2));
            //↓usernameからユーザのIPを取得
            ip1=dpinfo.getIP(name1);
            ip2=dpinfo.getIP(name2);
            System.out.println("ポート番号と接続IPの表示："+ip1+"→"+roundport1+";"+ip2+"→"+roundport2);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error：DynamicPeerInformationの処理が失敗してるよ");
        }
        
        try{
            ServerThread st1=new ServerThread(ip1,roundport1);
            System.out.println("ServerThread1実行完了");
            ServerThread st2=new ServerThread(ip2,roundport2);
            System.out.println("ServerThread2実行完了");            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error：サーバースレッドが生成できないっぽいよ");
        }

        
        /*
        try{
        //鍵の保存
        st1.SavePK();
        st2.SavePK();
        }catch(FileException e){
        
        }
        
        
        //xmlの書き込みが競合しないようにするフラグ管理
        st1.XmlFlg();
        st2.XmlFlg();
        
        try{
        //保存されている鍵の読み出し
        PK1=st1.ReadXml();
        PK2=st2.ReadXml();
        }catch(Exception e){
        
        }
        
        try{
        //本来のクライアントへ鍵を送信する
        st1.SendPK(PK2);
        st2.SendPK(PK1);
        }catch(Exception e){
        
        }
        
        */
        
        
        
    }
    public void Wait() {
	    try {
	        Thread.sleep(1 * 500);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
    
}









