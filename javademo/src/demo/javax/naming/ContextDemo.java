package demo.javax.naming;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ContextDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Hashtable<String, String> env = new Hashtable<String, String>(11);
        // use the file system as service provider
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.FSContextFactory");
        // env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        env.put(Context.PROVIDER_URL, "file://D:/temp");
        String name = "cradio.rar";
        String otherPath = "C:\\output.txt";
        try {
            Context ctx = new InitialContext(env);

            Object obj = ctx.lookup(name);
            System.out.println("the name \"" + name + "\" is bound to object: " + obj);

            obj = ctx.lookup(otherPath);
            System.out.println("the name \"" + otherPath + "\" is bound to object: " + obj);

            // 删除绑定，即删除文件
            ctx.unbind(otherPath);
            obj = ctx.lookup(otherPath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
