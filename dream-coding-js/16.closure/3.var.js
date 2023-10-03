function loop() {
  const array = [];
// var과 let의 차이점!
  for (let i = 0; i < 5; i++) {
    array.push(() => {
      console.log(i);
    });
  };
  return array;
};

const array = loop();
array.forEach((func) => func());

//var - 55555 출력
//let - 01234 출력
//var은 블록스코프가 없다(함수 스코프만 가지고있음) 


