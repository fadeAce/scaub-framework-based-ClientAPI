[![Build Status](https://ci.finogeeks.club/api/badges/plasmon/MessageJ/status.svg)](https://ci.finogeeks.club/plasmon/MessageJ)
# MessagingJ

message bus api for bridging clients communications into central bus.

[Get Startup Demo](https://git.finogeeks.club/Xia/plasmon-demo)

## API doc
###### MessagingJ v1.2 (transfer 1.2 , node 0.0.2)

##### * Java 7 or latter JDK
##### * maven 3 or latter runtime environment
##### * maven compiler plugin and dependency plugin
            <profiles>
                <profile>
                    <id>windows</id>
                    <activation>
                        <os>
                            <family>Windows</family>
                        </os>
                    </activation>
                    <properties>
                        <operation.system>windows</operation.system>
                    </properties>
                </profile>
                <profile>
                    <id>mac</id>
                    <activation>
                        <os>
                            <name>Mac OS X</name>
                        </os>
                    </activation>
                    <properties>
                        <operation.system>mac</operation.system>
                    </properties>
                </profile>
                <profile>
                    <id>linux</id>
                    <activation>
                        <os>
                            <family>unix</family>
                        </os>
                    </activation>
                    <properties>
                        <operation.system>linux</operation.system>
                    </properties>
                </profile>
            </profiles>
            
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-compiler-plugin</artifactId>
                        <configuration>
                            <source>1.7</source>
                            <target>1.7</target>
                        </configuration>
                    </plugin>
        
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-dependency-plugin</artifactId>
                        <executions>
                            <execution>
                                <id>unpack</id>
                                <phase>compile</phase>
                                <goals>
                                    <goal>unpack</goal>
                                </goals>
                                <configuration>
                                    <artifactItems>
                                        <artifactItem>
                                            <groupId>com.finogeeks.mediater</groupId>
                                            <artifactId>transfer</artifactId>
                                            <version>1.2</version>
                                            <classifier>${operation.system}</classifier>
                                            <type>jar</type>
                                            <overWrite>true</overWrite>
                                            <outputDirectory>${project.build.directory}/classes</outputDirectory>
                                            <includes>**/*.class,**/*.so,**/*.dll</includes>
                                        </artifactItem>
                                    </artifactItems>
                                </configuration>
                            </execution>
                        </executions>
                    </plugin>
                </plugins>
            </build>
##### * dependency of J/api: messagingJ
        <dependency>    
            <groupId>com.finogeeks.plasmon</groupId>
            <artifactId>MessagingJ</artifactId>
            <version>1.2</version>
        </dependency>



#### api usage 
###### you should create at least one message-handler as a Class that implement interface MessageHandler,in order to handle the message got from message bus
    import com.finogeeks.handler.MessageHandler;
    
    //a self-made Class used for handle callback functions when recieved message
    public class Assembler implements MessageHandler {
        //function that is used to call-back when message returns from the very topic subscribed former
        @Override
        public void execute(String format, String msg) {
            // do sth with msg
            System.out.println(msg);
        }
    }
###### create a client
    import com.finogeeks.execute.*;
    
    //client as an oms module instance
    Client client = new Client("oms","1"); 

###### publish a topic messages supported by message bus protocols
    import quickfix.Message;
    import quickfix.plasmon.Heartbeat;
    
    //message from plasmon protocal (actually support various message)
    client.publish("heartbeat",new Heartbeat());

###### subscribe a topic messages
    //handle message like a Assembler
    Subscription order_mike = client.subscribe("order","Account=mike",new Assembler());

###### query a topic messages
    //handle message like a Assembler
    client.query("order","Account=mike AND Symbol=IBM",new Assembler());

###### query and subscribe a topic messages
    //handle message like a Assembler
    Subscription order_query client.queryAndSubscribe("order","Account=mike AND Symbol=IBM",new Assembler());

###### unSub a topic
    client.unSub(order_mike);
    
###### unQuerySub a topic
    client.unQuerySub(order_query);
   
###### IsSystemService() return boolean
    Boolean tag = client.IsSystemService();

###### close a client
    client.close();
    
#### notice when building project
######  cache-server is needed
######  nats environment is needed
######  redis environment is needed
###### * do maven compile at project building
    run mvn -compile

#### feedback and report an issue
 send at : zbyzhengzong@outlook.com




