function execute() {
  console.log('1');
  setTimeout(() => {console.log('2');}, 3000);
  console.log('3');
};
execute(); //1 3 2
//setTimeout이 비동기적으로 작동되며 다음 단계로 넘어가고 3이 출력 된 뒤 
//3초 후 task queue에 들어간 뒤 콜스택이 비면 출력됨