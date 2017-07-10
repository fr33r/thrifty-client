package com.thriftyclient;

import com.thriftyclient.gen.PersonService;
import com.thriftyclient.gen.Person;
import org.apache.thrift.TException;

public class ThriftyClient{

  private PersonService.Client client;

  public ThriftyClient(PersonService.Client client){
    this.client = client;
  }

  public Person getPerson() throws TException {
    return this.client.get();
  }
}
