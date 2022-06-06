<!-- index教师/管理员页面中 欢迎部分ok -->
<template>
  <section class="index">
    <div class="hello">
      <i class="iconfont icon-xihuan"></i><span>很高兴遇见你,{{user.userName}}老师。</span>
    </div>
    <div class="msg">
      <p class="title">教务公告：</p>
      <ul>
        <li @click="openMsg1()"><i class="iconfont icon-flag"></i>清明节放假通知</li>
        <li @click="openMsg2()"><i class="iconfont icon-flag"></i>劳动节放假通知</li>
        <li @click="openMsg3()"><i class="iconfont icon-flag"></i>端午节放假通知</li>
      </ul>
    </div>
  </section>
</template>

<script>
export default {
  data() {
    return {
      user: { //用户信息
        userName: null,
        userId: null
      } 
    }
  },
  created() {
    this.getUserInfo()
  },
  methods: {
    getUserInfo() { //获取用户信息
      let userName = this.$cookies.get("cname")
      let userId = this.$cookies.get("cid")
      this.user.userName = userName
      this.user.userId = userId
    },
    openMsg1() {
      this.$alert('根据《国务院办公厅关于2022年部分节假日安排的通知》（国办发明电〔2021〕11号），结合我校具体情况，现将学校关于清明节的放假安排通知如下：4月3日至5日放假调休，共3天。4月2日（星期六）上班。','清明节放假通知',{
        confirmButtonText: '确定'
      })
    },
    openMsg2() {
      this.$alert('根据《国务院办公厅关于2022年部分节假日安排的通知》（国办发明电〔2021〕11号），结合我校具体情况，现将学校关于劳动节的放假安排通知如下：4月30日至5月4日放假调休，共5天。4月24日（星期日）、5月7日（星期六）上班。','劳动节放假通知',{
        confirmButtonText: '确定'
      })
    },
    openMsg3() {
      this.$alert('根据《国务院办公厅关于2022年部分节假日安排的通知》（国办发明电〔2021〕11号），结合我校具体情况，现将学校关于端午节的放假安排通知如下：6月3日至5日放假，共3天。','端午节放假通知',{
        confirmButtonText: '确定'
      })
    }
  }
}
</script>


<style lang="scss" scoped>
.index {
  margin-left: 70px;
  .hello {
    font-size: 20px;
    color: #726f70;
    .icon-xihuan {
      font-size: 30px;
      color: #dd6572;
    }
  }
  .msg {
    .title {
      font-size: 16px;
      color: #000;
      margin-top: 20px;
      margin-left: 10px;
    }
    ul {
      display: flex;
      flex-direction: column;
      width: 200px;
      overflow: hidden;
    }
    li {
      margin-top: 10px;
      font-size: 14px;
      color: lightcoral;
      cursor: pointer;
      display: inline-block;
    }
  }
}
</style>

