import java.rmi.*;
import java.io.*;

public interface srvint extends Remote
{
	public void getfile(String a,String b,StringBuffer s) throws RemoteException;
	public StringBuffer viewfile(String v) throws RemoteException;
   
	public StringBuffer misview() throws RemoteException;
	public StringBuffer details() throws RemoteException;
    public byte[] receivefile(String r) throws RemoteException;
    public byte[] storefile(String n) throws RemoteException;
   }
	
	