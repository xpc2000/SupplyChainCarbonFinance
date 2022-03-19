<template>
  <div class="container">
    <header-title :headerTitle="headerTitle"></header-title>

    <el-row>
      <el-col :span="6">
        <div class="card-box">
          <div class="colour-rec green"></div>
          <div class="board-icon">
            <img src="@/assets/header-icon/board-icon.svg" alt="" />
          </div>
          <div class="tanxin-title">供应链碳信总额度</div>
          <div class="money">4233.12万</div>
          <div class="rate">+25%</div>
          <div>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
          </div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="card-box">
          <div class="colour-rec blue"></div>
          <div class="board-icon">
            <img src="@/assets/header-icon/company-icon.svg" alt="" />
          </div>
          <div class="tanxin-title">供应链企业数量</div>
          <div class="money">1021</div>
          <div class="rate">+71%</div>
          <div>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
          </div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="card-box">
          <div class="colour-rec yellow"></div>
          <div class="board-icon">
            <img src="@/assets/header-icon/message-icon.svg" alt="" />
          </div>
          <div class="tanxin-title">未读信息数</div>
          <div class="money">76</div>
          <div class="rate">紧急信息：10</div>
          <div>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
          </div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="card-box">
          <div class="colour-rec purple"></div>
          <div class="board-icon">
            <img src="@/assets/header-icon/document-icon.svg" alt="" />
          </div>
          <div class="tanxin-title">等待审批</div>
          <div class="money">91</div>
          <div class="rate">+10</div>
          <div>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
          </div>
        </div>
      </el-col>
    </el-row>
    <div class="table-box">
      <el-row class="subcontent-title">
        <el-col :span="12">待办事项</el-col>
      </el-row>
      <el-row class="subcontent-bellow-body">
        <el-table :data="tableData" style="width: 100%">
          <el-table-column
            v-for="(item, index) in column"
            :key="index"
            :prop="item.prop"
            :label="item.label"
            :width="item.width"
            align="center"
          >
          </el-table-column>
        </el-table>
      </el-row>
    </div>
    <div class="table-box">
      <div class="subcontent-title">碳信生命周期流动</div>
      <div class="charts-box">
        <div id="main"></div>
        <div id="main2"></div>
      </div>
    </div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import headerTitle from "@/components/headerTitle.vue";
export default {
  data() {
    return {
      mychart: null,
      mychart2: null,
      headerTitle: {
        largeTitle: "管理后台首页",
        smallTitle: "面板",
      },
      column: [
        {
          prop: "task",
          label: "任务代办",
          width: "",
        },
        {
          prop: "time",
          label: "时间",
          width: "",
        },
        {
          prop: "status",
          label: "状态",
          width: "",
        },
      ],
      tableData: [
        {
          task: "供应链信息新通知",
          time: "2022-03-13 22：10：10",
          status: "未读",
        },
        {
          task: "供应链信息新通知",
          time: "2022-03-13 21：10：00",
          status: "未读",
        },
      ],
    };
  },
  components: {
    headerTitle,
  },
  mounted() {
    if (!this.mychart && !this.mychart2) {
      this.mychart = echarts.init(document.getElementById("main"));
      this.mychart2 = echarts.init(document.getElementById("main2"));
    }
    this.init();
    this.init2();
  },
  methods: {
    init() {
      var option = {
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true,
        },
        xAxis: {
          type: "value",
          axisTick: {
            show: false,
          },
          axisLine: {
            show: false,
          },
          boundaryGap: false,
        },
        yAxis: {
          type: "category",
          data: ["1", "2", "3", "4", "5"],
          axisLabel: {
            show: false,
          },
          axisLine: {
            show: false,
          },
          axisTick: {
            show: false,
          },
          splitLine: {
            show: true,
            lineStyle: {
              type: "dashed",
              dashOffset: 200,
            },
          },
        },
        grid: {
          left: "5%",
          right: "15%",
          bottom: "15%",
          containLabel: true,
          width: "85%",
          height: "70%",
        },
        series: [
          {
            name: "创建",
            type: "bar",
            stack: "总量",
            label: {
              normal: {
                show: true,
                position: "insideRight",
              },
            },
            itemStyle: {
              normal: {
                color: "#04B78A",
              },
            },
            data: [320, 302, 301, 334, 390, 330, 320],
          },
          {
            name: "销毁",
            type: "bar",
            stack: "总量",
            label: {
              normal: {
                show: true,
                position: "insideRight",
              },
            },
            itemStyle: {
              normal: {
                color: "#F2A626",
              },
            },
            data: [120, 132, 101, 134, 90, 230, 210],
          },
          {
            name: "转让",
            type: "bar",
            stack: "总量",
            label: {
              normal: {
                show: true,
                position: "insideRight",
              },
            },
            itemStyle: {
              normal: {
                color: "#156A59",
              },
            },
            data: [220, 182, 191, 234, 290, 330, 310],
          },
          {
            name: "回购",
            type: "bar",
            stack: "总量",
            label: {
              normal: {
                show: true,
                position: "insideRight",
              },
            },
            itemStyle: {
              normal: {
                color: "#A0A3BD",
              },
            },
            data: [150, 212, 201, 154, 190, 330, 410],
          },
          {
            name: "签收",
            type: "bar",
            stack: "总量",
            label: {
              normal: {
                show: true,
                position: "insideRight",
              },
            },
            itemStyle: {
              normal: {
                color: "#209F85",
              },
            },
            data: [234, 290, 330, 310, 290, 330, 310],
          },
        ],
      };

      option && this.mychart.setOption(option);
      window.addEventListener("resize", function () {
        this.mychart.resize();
      });
    },
    init2() {
      var option2 = {
        title: {
          subtext: "本月数据",
          left: "center",
        },

        color: [
          "#fc8251",
          "#5470c6",
          "#91cd77",
          "#ef6567",
          "#f9c956",
          "#75bedc",
        ],
        grid: {
          left: "5%",
          right: "15%",
          bottom: "15%",
          containLabel: true,
          width: "85%",
          height: "70%",
        },
        series: [
          {
            name: "GA 数据统计",
            type: "pie",
            radius: ["40%", "70%"],
            // avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: "#fff",
              borderWidth: 2,
            },
            label: {
              show: false,
              position: "center",
            },

            labelLine: {
              show: false,
            },
            data: [
              { value: 1017, name: "搜索引擎" },
              { value: 583, name: "直接访问" },
              { value: 873, name: "微信朋友圈" },
              { value: 432, name: "口碑介绍" },
              { value: 332, name: "电话销售" },
              { value: 678, name: "Feeds 广告" },
            ],
          },
        ],
      };
      option2 && this.mychart2.setOption(option2);
      window.addEventListener("resize", function () {
        this.mychart2.resize();
      });
    },
  },
};
</script>

<style>
.card-box {
  display: flex;
  flex-direction: column;
  background: #fff;
  margin: 30px 20px 15px 40px;
  border-radius: 0px 0px 25px;
  height: 150px;
  position: relative;
}
.colour-rec {
  height: 150px;
  width: 5px;
  position: absolute;

  top: 0%;
}
.green {
  background: #156a59;
}
.blue {
  background: #209f85;
}
.yellow {
  background: #f2a626;
}
.purple {
  background: #242f57;
}
.board-icon {
  position: absolute;
  right: 30px;
  top: 20px;
}
.tanxin-title {
  font-size: 15px;
  padding: 30px 0px 10px 30px;
}
.money {
  font-size: 24px;
  padding: 0px 0px 10px 30px;
}
.rate {
  font-size: 15px;
  padding-left: 30px;
  color: #4bde97;
}
#main {
  display: block;
  margin: 0px 70px 0px 0px;
  width: 70%;
  height: 200px;
  background: #fff;
  border-radius: 25px;
}
#main2 {
  display: block;
  margin: 0px 0px 0px 0px;
  width: 20%;
  height: 200px;
  background: #fff;
  border-radius: 25px;
}
.header-slogan {
  margin: 50px auto;

  height: 50px;
  width: 800px;
  background-color: white;
}
.charts-box {
  display: flex;
  height: 200px;
}
.subcontent-title {
  padding-bottom: 20px;
  color: #a0a3bd;
}
.table-box {
  margin: 20px 0px 0px 40px;
  width: 95%;
}
</style>
