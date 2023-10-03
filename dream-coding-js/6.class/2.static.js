// static 정적 프로퍼티 와 메서드 (클래스 레벨 프로퍼티와 메서드)

// 인스턴스 레벨의 프로퍼티와 메서드의 경우 
// consol.log(Fruit.name); Fruit.display(); 를 호출할 수 없음!!
//(클래스 자체는 데이터가 채워져있지 않기 때문)
// 인스턴스 레벨의 프로퍼티와 메서드는 꼭 생성된 인스턴스를 통해서만
// 접근하고 호출되어야 한다!!
// 클래스 레벨의 프로퍼티와 메서드의 경우 인스턴스 안에는 존재하지 않고
// 클래스 안에서만 존재하며 클래스를 통해서만 접근하고 호출될 수 있다.

class Fruit {
  constructor(name, emoji) {
    this.name = name,
    this.emoji = emoji;
  }

  //클래스 레벨의 메서드
    static makeRandomFruit() {
      // 클래스 레벨의 메서드에서는 this를 참조할 수 없음
      return new Fruit('banana', '🍌');
    }
  
  //인스턴스 레벨의 메서드
    display = function() {
    console.log(`${this.name}: ${this.emoji}`);
  };
};

//클래스 레벨의 메서드의 경우 클래스를 통해서 접근 및  호출이 가능하다
const banana = Fruit.makeRandomFruit();
console.log(banana);

// apple은 Fruit 클래스의 인스턴스이다.
const apple = new Fruit('apple', '🍎');
// orange은 Fruit 클래스의 인스턴스이다.
const orange = new Fruit('orange', '🍊');

console.log(apple);
console.log(orange);


