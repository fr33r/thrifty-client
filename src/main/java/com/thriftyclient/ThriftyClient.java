package com.thriftyclient;

import com.thriftyclient.gen.PersonService;
import com.thriftyclient.gen.Person;

public class ThriftyClient{

  private PersonService.Client client;

  public ThriftyClient(PersonService.Client client){
    this.client = client;
  }

  public Person getPerson(){
    return this.client.get();
  }
}
