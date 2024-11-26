class Employee {}

class Engineer extends Employee {}
class Salesperson extends Employee {
  //quota()가 Salesperson에서만 사용되는 메서드인 경우 
  get quota() {}
}
