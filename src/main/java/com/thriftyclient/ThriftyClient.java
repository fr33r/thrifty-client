package com.thriftyclient;

import com.thrifty.gen.PersonService;
import com.thrifty.gen.Person;
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
