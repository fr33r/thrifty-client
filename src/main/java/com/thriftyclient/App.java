package com.thriftyclient;

import com.thrifty.gen.Person;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TSimpleJSONProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import com.thrifty.gen.PersonService;
import org.apache.thrift.transport.TTransportException;

public class App{

  private String address;
  private int port;
  private TTransport transport;
  private TProtocol protocol;
  private ThriftyClient client;

  public App(String address, int port){
    this.address = address;
    this.port = port;
    this.transport = new TSocket(this.address, this.port);
    this.protocol = new TSimpleJSONProtocol(transport);
    this.client = new ThriftyClient(new PersonService.Client(protocol));
  }

  public void startup() throws TTransportException {
    transport.open();
  }

  public ThriftyClient getClient(){
    return this.client;
  }

  public void shutdown(){
    transport.close();
  }

  public static void main(String[] args) throws TTransportException {
    App application = new App("localhost", 9090);
    application.startup();
    System.out.println("startup successful!");

    //do stuff!
    Person person = null;
    try {
      person = application.getClient().getPerson();
      System.out.println(person);
    } catch (TException e) {
      e.printStackTrace();
    }

    application.shutdown();
    System.out.println("shutdown successful!");
  }
}
