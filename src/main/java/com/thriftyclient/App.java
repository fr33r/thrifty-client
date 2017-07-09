package com.thriftyclient;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TSimpleJSONProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import com.thriftyclient.gen.PersonService;

public class App{

  private String address;
  private int port;
  private TTransport transport;
  private TProtocol protocol;
  private ThriftClient client;

  public App(string address, int port){
    this.address = address;
    this.port = port;
    this.transport = new TSocket(this.address, this.port);
    this.protocol = new TSimpleJSONProtocol(transport);
    this.client = new ThriftyClient(new PersonService.Client(protocol));
  }

  public void startup(){
    transport.open();
  }

  public void shutdown(){
    transport.close();
  }

  public static void main(String[] args){
    App application = new App("localhost", 9090);
    application.startup();
    System.out.println("startup successful!");

    //do stuff!
    Person person = this.client.getPerson();
    System.out.println(person);

    application.shutdown();
    System.out.println("shutdown successful!");
  }
}
