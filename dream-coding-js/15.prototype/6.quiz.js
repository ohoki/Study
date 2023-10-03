//클래스를 베이스로 한 객체지향 프로그래밍
class Animal {
  constructor(name, emoji) {
    this.name = name,
  this.emoji = emoji;
  };
  printName () {
    console.log(`${this.name} ${this.emoji}`);
  };
};

class Dog extends Animal {
  play () {
    console.log('같이 놀자 닝겐!');
  };
}

class Tiger extends Animal {
  hunt () {
    console.log('사냥한다 냠냠');
  };
};

const dog1 = new Dog('멍멍', '🐶', '영호');
const tiger1 = new Tiger('어흥', '🐯');

console.log(dog1);
dog1.printName();
dog1.play();
console.log(tiger1);
tiger1.printName();
tiger1.hunt();


//instanceof - 객체가 누구를 상속하는지 어떤 클래스 또는 생성자 함수의 인스턴스인지
//확인할 수 있음
console.log(dog1 instanceof Dog);
console.log(dog1 instanceof Animal);
console.log(dog1 instanceof Tiger);