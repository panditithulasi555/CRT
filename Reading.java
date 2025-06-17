import java.io.File;
File myFile=new File("example.txt");
if(myFile.exists())
{
	System.out.println("file exists:"+myFile.getName
}
else{
	System.out.println("file does not exists.");
}