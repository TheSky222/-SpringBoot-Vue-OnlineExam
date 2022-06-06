import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login', //登录界面ok
      component: () => import('@/components/common/login')
    },
    {
      path: '/index', //教师主页ok
      component: () => import('@/components/admin/index'),
      children: [
        {
          path: '/', //首页默认路由ok
          component: () => import('@/components/common/hello')
        },
        {
          path:'/grade', //学生成绩no ok页面无显示
          component: () => import('@/components/charts/grade')
        },
        {
          path: '/selectExamToPart', //成绩分段查询ok
          component: () => import('@/components/teacher/selectExamToPart')
        },
        {
          path: '/scorePart', //成绩分段图表ok
          component: () => import('@/components/charts/scorePart')
        },
        {
          path: '/allStudentsGrade', //所有学生成绩统计no ok
          component: () => import('@/components/teacher/allStudentsGrade')
        },
        {
          path: '/examDescription', //考试管理功能描述ok
          component: () => import('@/components/teacher/examDescription')
        },
        {
          path: '/selectExam', //查询所有考试ok
          component: () => import('@/components/teacher/selectExam')
        },
        {
          path: '/addExam', //添加考试ok
          component: () => import('@/components/teacher/addExam')
        },
        {
          path: '/answerDescription', //题库管理功能介绍ok
          component: ()=> import('@/components/teacher/answerDescription')
        },
        {
          path: '/selectAnswer', //查询所有题库ok
          component: () => import('@/components/teacher/selectAnswer')
        },
        {
          path: '/addAnswer', //增加题库主界面ok
          component: () => import('@/components/teacher/addAnswer')
        },
        {
          path: '/addAnswerChildren', //点击试卷跳转到添加题库页面no ok 东西太多
          component: () => import('@/components/teacher/addAnswerChildren')
        },
        {
          path: '/studentManage', //学生管理界面no ok 编辑和删除有bug
          component: () => import('@/components/teacher/studentManage')
        },
        {
          path: '/addStudent', //添加学生ok
          component: () => import('@/components/teacher/addStudent')
        },
        {
          path: '/teacherManage', //教师管理界面no ok 编辑和删除有bug
          component: () => import('@/components/admin/tacherManage')
        },
        {
          path: '/addTeacher', //添加教师ok
          component: () => import ('@/components/admin/addTeacher')
        }
      ]
    },
    {
      path: '/student', //学生界面ok
      component: () => import('@/components/student/index'),
      children: [
        {
          path:"/", //我的试卷界面ok
          component: ()=> import('@/components/student/myExam')
        },
        {
          path:'/startExam', //我的练习界面ok
          component: () => import('@/components/student/startExam')
        },
        {
          path: '/manager', //管理中心 修改密码ok
          component: () => import('@/components/student/manager')
        },
        {
          path: '/examMsg', //考试信息界面ok
          component: () => import('@/components/student/examMsg')
        },
        {
          path: '/message', //给我留言界面ok
          component: () => import('@/components/student/message')
        },
        {
          path: '/studentScore', //考试成绩界面ok
          component: () => import("@/components/student/answerScore")
        },
        {path: '/scoreTable', //我的分数界面ok
        component: () => import("@/components/student/scoreTable")
      }
      ]
    },
    {
      path: '/answer', //考试界面no ok 内容有点多
      component: () => import('@/components/student/answer')
    }

  ]
})
