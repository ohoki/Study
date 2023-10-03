class Fruit {
  #name;  //클래스 내부에 있는 변수를 field라고 하며  constructor에서 주어지는
  #emoji; //데이터라면 생략 가능함
  #type = '과일'; //접근제어자 - 캡슐화 (내부상에 필요한 데이터를 외부에서 보이지 않도록, 수정할 수 없도록 캡슐처럼 꽁꽁 막아둠)
  //private (#), public (기본값), protected
  constructor(name, emoji) {
    this.#name = name,
    this.#emoji = emoji;
  }
    display = () => {
    console.log(`${this.#name}: ${this.#emoji}`);
  };
};

const apple = new Fruit('apple', '🍎');
//apple.name = '오렌지'; -#field는 외부에서 변경이 불가능함!!
console.log(apple); // Fruit { display: [Function: display] }
