import VUE from 'vue'
import VUEX from 'vuex'

VUE.use(VUEX) 
// Vuex 是一个专为 Vue.js 应用程序开发的状态管理模式。它采用集中式存储管理应用的所有组件的状态，并以相应的规则保证状态以一种可预测的方式发生变化。
// vuex由五个部分组成，分别是State，Mutation，Action，Module，Getter。

// 共享状态（即变量）
const state = {
  isPractice: false, //练习模式标志
  flag: false, //菜单栏左右滑动标志
  userInfo: null,
  menu: [{
      index: '1',
      title: '考试管理',
      icon: 'icon-kechengbiao',
      content:[{item1:'功能介绍',path:'/examDescription'},{item2:'考试查询',path:'selectExam'},{item3:'添加考试',path:'/addExam'}],
    },
    {
      index: '2',
      title: '题库管理',
      icon: 'icon-tiku',
      content:[{item1:'功能介绍',path:'/answerDescription'},{item2:'所有题库',path:'/selectAnswer'},{item3:'增加题库',path:'/addAnswer'},{path: '/addAnswerChildren'}],
    },
    {
      index: '3',
      title: '成绩查询',
      icon: 'icon-performance',
      content:[{item1:'学生成绩查询',path:'/allStudentsGrade'},{path: '/grade'},{item2: '成绩分段查询',path: '/selectExamToPart'},{path: '/scorePart'}],
    },
    {
      index: '4',
      title: '学生管理',
      icon: 'icon-role',
      content:[{item1:'学生管理',path:'/studentManage'},{item2: '添加学生',path: '/addStudent'}],
    },
    // {
    //   index: '5',
    //   title: '教师管理',
    //   icon: 'icon-Userselect',
    //   content:[{item1:'教师管理',path:'/teacherManage'},{item2: '添加教师',path: '/addTeacher'}],
    // },
    // {
    //   index: '7',
    //   title: '模块管理',
    //   icon: 'icon-module4mokuai',
    //   content:[{item1:'模块操作',path:'/module'}],
    // }
  ],
}
// 更改vuex的store中state的唯一方法，只有通过提交mutation才能修改状态（变量值）
const mutations = {
  practice(state,status) {
    state.isPractice = status
  },
  toggle(state) {
    state.flag = !state.flag
  },
  changeUserInfo(state,info) {
    state.userInfo = info
  }
}
// 基于state的派生状态，可理解为组件中的计算属性
const getters = {
 
}
// 类似mutation，修改store中的状态。但是刚才说过只有通过提交mutation才能修改状态，
// 所以Action也是通过提交mutation修改store中的状态 ，与Mutataion不同的是Action支持异步操作
const actions = {
  getUserInfo(context,info) {
    context.commit('changeUserInfo',info) 
    // dispatch：含有异步操作，例如向后台提交数据，写法： this.$store.dispatch('mutations方法名',值)
    // commit：同步操作，写法：this.$store.commit('mutations方法名',值)
  },
  getPractice(context,status) {
    context.commit('practice',status)
  }
}
// 提供一个接口给外界，让其他文件通过 import 来引入使用
export default new VUEX.Store({
  state,
  mutations,
  getters,
  actions,
  // store
})
