package com.countryside_culture.config;

import com.countryside_culture.Interceptor.HandShkeInceptor;
import com.countryside_culture.Interceptor.MyChannelInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by hushangjie on 2017/6/12.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    //    //拦截器注入service失败解决办法
    @Bean
    public MyChannelInterceptor myChannelInterceptor() {
        return new MyChannelInterceptor();
    }

    //注册STOMP协议的节点，并指定映射的URL
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        /**
         * 注册STOMP协议节点，同时指定使用SockJS协议，在前端界面中会使用该处的节点进行SocKet连接
         * 添加访问域名限制可以防止跨域soket连接
         * */
        //setAllowedOrigins("http://localhost:8085")
        stompEndpointRegistry.addEndpoint("/live").setAllowedOrigins("*").addInterceptors(new HandShkeInceptor()).withSockJS();

    }

    //配置消息代理
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // System.out.println("配置队列中");
        // 主机自带内存消息队列
        /*.enableSimpleBroker("/topic","/queue");*/
        //假如需要第三方消息队列，比如rabitMQ,activeMq，在这里配置
        registry.setApplicationDestinationPrefixes("/app")
                .enableStompBrokerRelay("/topic", "/queue")
                .setRelayHost("127.0.0.1")
                .setRelayPort(61613)
                .setClientLogin("guest")
                .setClientPasscode("guest")
                .setSystemLogin("guest")
                .setSystemPasscode("guest")
                .setSystemHeartbeatSendInterval(5000)
                .setSystemHeartbeatReceiveInterval(4000);
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        ChannelRegistration channelRegistration = registration.setInterceptors(myChannelInterceptor());
        super.configureClientInboundChannel(registration);
    }

    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        super.configureClientOutboundChannel(registration);
    }

    /*@Override
    public void configureWebSocketTransport(final WebSocketTransportRegistration registration) {
        registration.addDecoratorFactory(new WebSocketHandlerDecoratorFactory() {
            @Override
            public WebSocketHandler decorate(final WebSocketHandler handler) {
                return new WebSocketHandlerDecorator(handler) {
                    @Override
                    public void afterConnectionEstablished(final WebSocketSession session) throws Exception {
                        // 客户端与服务器端建立连接后，此处记录谁上线了
                        String username = session.getPrincipal().getName();
                        //log.info("online: " + username);
                        System.out.println("online: " + username);
                        super.afterConnectionEstablished(session);
                    }

                    @Override
                    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
                        // 客户端与服务器端断开连接后，此处记录谁下线了
                        String username = session.getPrincipal().getName();
                        // log.info("offline: " + username);
                        System.out.println("offline: " + username);
                        super.afterConnectionClosed(session, closeStatus);
                    }
                };
            }
        });
        super.configureWebSocketTransport(registration);
    }*/

}
