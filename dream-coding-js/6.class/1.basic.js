//객체를  손쉽게 만들 수 있는 템플릿
//1. 생성자 함수 (오래된 고전적 방법)
//2. 클래스 함수 (GOOD!!)

// 클래스 (Class)
class Fruit {
  //생성자(constructor): new 키워드로 객체를 생성할 때 호출되는  함수
  constructor(name, emoji) {
    this.name = name,
    this.emoji = emoji;
  }
    //객체 안에서 사용되는 멤버 함수의 경우 function 없이 이름만 작성
    display = function() {       //function display = () => {} ❌
    console.log(`${this.name}: ${this.emoji}`);
  };
};

// apple이란 객체는 Fruit 클래스의 인스턴스이다.
const apple = new Fruit('apple', '🍎');
//orange이란 객체는 Fruit 클래스의 인스턴스이다.
const orange = new Fruit('orange', '🍊');

console.log(apple);
console.log(orange);

//obj는 객체이고, 그 어떤 클래스의 인스턴스도 아니다.
const obj = {name: 'youngho'};



//클래스를 통해서 인스턴스를 찍어낼 수 있다. 이 때 동일한 프로퍼티와 메소드가
//들어가기 때문에 이를 전부 다 '인스턴스 레벨의 프로퍼티와 메서드'다 라고 할 수 있다
