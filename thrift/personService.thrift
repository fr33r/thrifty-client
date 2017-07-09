namespace java com.thriftyclient.gen

include "person.thrift"

/**
 * Service responsible for all interactions with Person objects.
 */
service PersonService {

  person.Person get()

}
