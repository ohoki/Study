export class Site {
  constructor(customer) {
    customer === 'unknown' ? this._customer = new unknownCustomer(customer) : this._customer = new Customer(customer);
  }

  get customer() {
    return this._customer;
  }
}

export class Customer {
  constructor(name) {
    this._name = name;
  }

  get name() {
    return this._name;
  }

  get billingPlan() {
    //
  }

  set billingPlan(arg) {
    //
  }

  get paymentHistory() {
    //
  }
}

class unknownCustomer extends Customer {
  get name() {
    return 'occupant';
  }
}


// 사용하는 부분
export function customerName(site) {
  const aCustomer = site.customer;
  
  return aCustomer.name;
}

const result = customerName(new Site('unknown'));

console.log(result);