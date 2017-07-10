namespace java com.thrifty.gen
namespace go thrifty

include "person.thrift"

/**
 * Service responsible for all interactions with Person objects.
 */
service PersonService {
  person.Person get()
}
