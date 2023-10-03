// class Tiger {
//   constructor(color) {
//     this.color = color;
//   }
//   eat() {
//     console.log('먹자!');
//   }
//   sleep() {
//     console.log('잔다~');
//   }
// }

// class Dog {
//   constructor(color) {
//     this.color = color;
//   }
//   eat() {
//     console.log('먹자!');
//   }
//   sleep() {
//     console.log('잔다~');
//   }
//   play() {
//     console.log('놀자~!');
//   }
// }

//상속 - 공통된 속성과 행동을 그대로 상속해줄 수 있음 
class Animal {
  constructor(color) {
    this.color = color;
  }
  eat() {
    console.log('먹자!');
  }
  sleep() {
    console.log('잔다~');
  }
}

class Tiger extends Animal {}
const tiger = new Tiger('노랑이');
console.log(tiger);
tiger.eat();
tiger.sleep();

class Dog extends Animal {
  //새로운 생성자 추가 (기존의 생성자도 같이 기입해줘야 함)
  //super - 부모의 클래스를 가리킨다.
  constructor(color, ownerName) {
    super(color);
    this.ownerName = ownerName;
  }
  play() {
    console.log('놀자~!');
  }
// 부모의 함수에 다른 함수를 추가하거나 변경하고 싶은 경우 - 오버라이딩(overriding)
  eat() {
    super.eat();
    console.log('강아지가 먹는다!');
  }
}
const dog = new Dog('하양이', '영호')
console.log(dog);
  dog.eat();
  dog.sleep();
  dog.play();
 