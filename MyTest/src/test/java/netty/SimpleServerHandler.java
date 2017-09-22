package netty;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class SimpleServerHandler extends ChannelInboundHandlerAdapter {  
	  
    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  
        ByteBuf buf = (ByteBuf)msg;  
        byte [] req = new byte[buf.readableBytes()];  
        buf.readBytes(req);  
        String message = new String(req,"UTF-8");  
//        ReferenceCountUtil.release(buf);
		
        System.out.println("Netty-Server:Receive Message,"+ message);  
        ByteBuf in = Unpooled.copiedBuffer(message,Charset.forName("GBK"));
		ctx.writeAndFlush(in).addListener(ChannelFutureListener.CLOSE);
		
    }  
}  

