export class Order {
  constructor(priority) {
    this.priority = priority;
  }

  isHighPriority() {
    return this.priority.equals(new Priority('high')) || this.priority.equals(new Priority('rush'));
  }
}

class Priority {
  #value;
  constructor(value) {
    if(Priority.legalValue().includes(value)) {
      this.#value = value;
    } else {
      throw new Error(`${value} is invalid for Priority`);
    }
  }

  get index() {
    return Priority.legalValue().indexOf(this.#value);
  }

  equals(other) {
    return this.index === other.index;
  }

  higherThan(other) {
    return this.index > other.index;
  }

  static legalValue() {
    return ['low', 'normal', 'high', 'rush'];
  }
}

const orders = [
  new Order(new Priority('normal')),
  new Order(new Priority('high')),
  new Order(new Priority('rush')),
];

const highPriorityCount = orders.filter( (o) => o.isHighPriority() ).length;

console.log(highPriorityCount);
