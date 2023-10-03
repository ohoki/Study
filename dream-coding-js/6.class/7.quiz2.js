//정직원과 파트타임직원을 나타낼 수 있는 클래스를 만들어 보자
//직원들의 정보: 이름, 부서이름, 한달 근무 시간
//매달 직원들의 정보를 이용해서 한달 월급을 계산할 수 있다
//정직원은 시간당 10000원
//파트타임 직원은 시간당 8000원

//youngho's solution

class Employee {
  constructor (name, department, time, hourlyWage) {
    this.name = name;
    this.department = department;
    this.time = time;
    this.hourlyWage = hourlyWage;
  }
  get monthlPayment() {
    return this.#payment();
  }
  #payment = () => {
    return this.time * this.hourlyWage;
  }
}

class RegularEmployee extends Employee {
  static hourlyWage = 10000;
  constructor(name, department, time) {
  super(name, department, time, RegularEmployee.hourlyWage)
  }
} 

class  PartTimeEmployee extends Employee {
  static hourlyWage = 10000;
  constructor(name, department, time) {
    super(name, department, time, PartTimeEmployee.hourlyWage)
  }
}

const regularEmployee = new RegularEmployee('최영호', '백엔드', 170);
console.log(regularEmployee.monthlPayment);
const partTimeEmployee = new PartTimeEmployee('김철수', '청소', 80);
console.log(partTimeEmployee.monthlPayment); 