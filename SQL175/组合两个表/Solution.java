package SQL175.组合两个表;


public class Solution {
    /*
    *     Create table Person (PersonId int, FirstName varchar(255), LastName varchar(255))
          Create table Address (AddressId int, PersonId int, City varchar(255), State varchar(255))
          Truncate table Person
          insert into Person (PersonId, LastName, FirstName) values ('1', 'Wang', 'Allen')
          Truncate table Address
          insert into Address (AddressId, PersonId, City, State) values ('1', '2', 'New York City', 'New York')
    * */

    public static void main(String[] args) {
        String solution = " select FirstName, LastName, City, State from Person left join Address on Person.PersonId = Address.PersonId ";
    }
}
