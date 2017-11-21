package netty.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

  
public class HelloClient {
    public void connect(String host, int port) throws Exception {  
        EventLoopGroup workerGroup = new NioEventLoopGroup();  
  
        try {  
            Bootstrap b = new Bootstrap();  
            b.group(workerGroup);  
            b.channel(NioSocketChannel.class);  
            b.option(ChannelOption.SO_KEEPALIVE, true);  
            b.handler(new ChannelInitializer<SocketChannel>() {  
                @Override  
                public void initChannel(SocketChannel ch) throws Exception {  
                    ch.pipeline().addLast(new HelloClientIntHandler());  
                }  
            });  
  
            // Start the client.  
            ChannelFuture f = b.connect(host, port).sync();  
            f.channel().closeFuture().sync();  
        } finally {  
            workerGroup.shutdownGracefully();  
        }  
    }  
  
    public static void main(String[] args) throws Exception {  
        HelloClient client = new HelloClient();  
        client.connect("127.0.0.1", 8989);  
    }  
}  



class HelloClientIntHandler extends ChannelInboundHandlerAdapter {  
    private static Logger   logger  = LoggerFactory.getLogger(HelloClientIntHandler.class);  
    @Override  
    // 读取服务端的信息  
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  
        logger.info("HelloClientIntHandler.channelRead");  
        ByteBuf result = (ByteBuf) msg;  
        byte[] result1 = new byte[result.readableBytes()];  
        result.readBytes(result1);  
        result.release();  
        ctx.close();  
        System.out.println("Server said:" + new String(result1));  
    }  
    @Override  
    // 当连接建立的时候向服务端发送消息 ，channelActive 事件当连接建立的时候会触发  
    public void channelActive(ChannelHandlerContext ctx) throws Exception {  
        logger.info("HelloClientIntHandler.channelActive");  
        String msg = "Are you ok?";  
        ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());  
        encoded.writeBytes(msg.getBytes());  
        ctx.write(encoded);  
        ctx.flush();  
    }  
}