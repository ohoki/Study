//object에 함수가 포함된 경우

const apple = {
  name: 'apple',
  display: function() {
    console.log(`${this.name}: 🍎`); 
  }
}
//객체 안에서 자기 자신의 속성을 접근할 때엔 항상 this를 붙여줘야 함!!

apple.display();