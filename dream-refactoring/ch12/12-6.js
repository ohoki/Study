class Employee {
  #name;
  constructor(name) {
    this.#name = name;
  }

  get type() {
    return 'employee';
  }

  toString() {
    return `${this.#name} (${this.type})`;
  }

  static createEmployees(name, type) {
    switch (type) {
      case 'engineer':
        return new Enginner(name);
      case 'salesperson':
        return new Salesperson(name);
      case 'manager':
        return new Manager(name);
      default:
        throw new Error(`${type}라는 직원 유형은 없습니다.`);
    }
  }
}

class Enginner extends Employee {
  get type() {
    return 'engineer';
  }
}

class Manager extends Employee {
  get type() {
    return 'manager';
  }
}

class Salesperson extends Employee {
  get type() {
    return 'salesperson';
  }
}

const ellie = new Employee('엘리');
const bob = new Employee('밥');
