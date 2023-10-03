'use strict';

// Make navbar transparent when it is on the top
const navbar = document.querySelector('#navbar');
const navbarHeight = navbar.getBoundingClientRect().height;
document.addEventListener('scroll', () => {
  // console.log(window.scrollY);
  // console.log(`navbar: ${navbarHeight}`);
  if(window.scrollY > navbarHeight) {
    navbar.classList.add('navbar--dark');
  } else {
    navbar.classList.remove('navbar--dark');
  };
});

// Handle scrolling when tapping on the navbar menu

const navbarMenu = document.querySelector('.navbar__menu');
navbarMenu.addEventListener('click', (event) => {
  const target =  event.target;
  const link = target.dataset.link;
  if (link == null) {
    return;
  };
  navbarMenu.classList.remove('open');
  // console.log(event.target.dataset.link);
  // const scrollTo = document.querySelector(link);
  // scrollTo.scrollIntoView({behavior: 'smooth'});
  scrollIntoView(link);
  selectNavItem(target);
});

//Navbar toggle button for small screen
const navbarToggleBtn = document.querySelector('.navbar__toggle-btn');
navbarToggleBtn.addEventListener('click', () => {
  navbarMenu.classList.toggle('open');
});

//Handle click on "contact me" button on home
const homContactBtn = document.querySelector('.home__contact');
homContactBtn.addEventListener('click', () => {
  // const scrollTo = document.querySelector('#contact');
  // scrollTo.scrollIntoView({behavior: 'smooth'});
  scrollIntoView('#contact');
});

//Make home slowly fade to transparent as the window scrolls down
const home = document.querySelector('.home__container');
const homeHeight = home.getBoundingClientRect().height;
document.addEventListener('scroll', () => {
    home.style.opacity = 1 - window.scrollY / homeHeight;
});

//Show "arrow up" button when scrolling down
const arrowUp = document.querySelector('.arrow-up');
document.addEventListener('scroll', () => {
  if (window.scrollY > homeHeight / 2) {
    arrowUp.classList.add('visible');
  } else {
    arrowUp.classList.remove('visible');
  };
});

//Handle click on the "arrow up" button
arrowUp.addEventListener('click', () => {
  scrollIntoView('#home');
});

//Remove selection from the previous item and select the new one
const workBtnContainer = document.querySelector('.work__categories');
workBtnContainer.addEventListener('click', (e) => {
  const select = document.querySelector('.category__btn.selected');
  select.classList.remove('selected');
  const target =
  e.target.nodeName === 'BUTTON' ? e.target : e.target.parentNode;
  target.classList.add('selected');
  }
);

//Projects
const ProjectContainer = document.querySelector('.work__projects');
const projects = document.querySelectorAll('.project');
workBtnContainer.addEventListener('click', (e) => {
  const filter = e.target.dataset.filter || e.target.parentNode.dataset.filter;
  if(filter == null) {
    return;
  }
  ProjectContainer.classList.add('anm-out');        
  setTimeout(() => {
    projects.forEach((project) => {
      if(filter === '*' || filter === project.dataset.type) {
        project.classList.remove('invisible');
      } else {
        project.classList.add('invisible');
      }
    });
    ProjectContainer.classList.remove('anm-out'); 
  }, 300);
});

//스크롤 시 메뉴 활성화 시키기

//1. 모든 섹션 요소들을 가지고 온다.
const sectionIds = [
  '#home',
  '#about',
  '#skills',
  '#work',
  '#testimonials',
  '#contact',
];
const sections = sectionIds.map((id) => document.querySelector(id));
const navItems = sectionIds.map((id) => document.querySelector(`[data-link="${id}"]`));

//2. IntersectionObserver를 이용해서 모든 섹션들을 관찰한다.
let selectedNavIndex = 0;
let seletedNavItem = navItems[0];
function selectNavItem(selected) {
  seletedNavItem.classList.remove('active');
  seletedNavItem = selected;
  seletedNavItem.classList.add('active');
};

const observerOptions = {
  root: null,
  rootMargine: '0px',
  threshold: 0.3,
};

const observerCallback = (entries, observer) => {
  entries.forEach((entry) => {
    if (!entry.isIntersecting && entry.intersectionRatio > 0) {
      const index = sectionIds.indexOf(`#${entry.target.id}`);
      //스크롤이 아래로 되어서 페이지가 올라감
      if (entry.boundingClientRect.y < 0) {
        selectedNavIndex = index + 1;
      } else {
        selectedNavIndex = index - 1;
      };
    };
  });
};

const observer = new IntersectionObserver(observerCallback, observerOptions);
sections.forEach((section) => observer.observe(section));

//3. 보여지는 섹션에 해당하는 메뉴 아이템을 활성화 시킨다.
window.addEventListener('wheel', () => {
  if(window.scrollY === 0) {
    selectedNavIndex = 0;
  } else if (Math.round(window.scrollY + window.innerHeight) >= document.body.clientHeight) {
    selectedNavIndex = navItems.length -1;
  }
  selectNavItem(navItems[selectedNavIndex]);
});

function scrollIntoView(selector) {
  const scrollTo = document.querySelector(selector);
  scrollTo.scrollIntoView({behavior: 'smooth'});
  selectNavItem(navItems[sectionIds.indexOf(selector)]);
};
