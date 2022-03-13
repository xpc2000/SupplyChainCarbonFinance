<template>
  <div class="sub-content-box">
    <header-title :headerTitle="headerTitle"></header-title>

    <div class="sub-content-body">
      <el-row class="subcontent-title">
        <el-col :span="12">碳控排链信账户款项流动仪表盘</el-col>
        <el-col :span="12" class="refresh-data">
          <el-row> {{ companyName }} {{ chainName }}</el-row>
          <el-row class="detail-card-title">
            <span class="refresh" @click="refresh">刷新</span>
            <i class="el-icon-refresh refresh"></i>
          </el-row>
        </el-col>
      </el-row>
      <el-row class="subcontent-top-body">
        <!-- echarts图表 -->
        <el-col :span="12" id="main"></el-col>
        <!-- 企业信息卡片 -->
        <el-col :span="12" class="detail-card">
          <el-row :gutter="10">
            <el-row>
              <el-col :span="12">
                <el-row class="detail-card-title">质押碳配额数量</el-row>
                <el-row class="detail-card-content">
                  {{ emissionPledged }}
                </el-row>
              </el-col>
              <el-col :span="12">
                <el-row class="detail-card-title">已发行碳信余额</el-row>
                <el-row class="detail-card-content">{{ carbonLimit }}</el-row>
              </el-col>
            </el-row>

            <el-row class="detail-card-margin">
              <el-col :span="12">
                <el-row class="detail-card-title">已回购碳信余额</el-row>
                <el-row class="detail-card-content">{{ ticketBuyback }}</el-row>
              </el-col>
              <el-col :span="12">
                <el-row class="detail-card-title">可发行碳信余额</el-row>
                <el-row class="detail-card-content">{{
                  ticketUnissued
                }}</el-row>
              </el-col>
            </el-row>
          </el-row>
        </el-col>
      </el-row>

      <el-row class="subcontent-title">
        <el-col :span="12">碳信创建历史</el-col>
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
  </div>
</template>
<script>
import * as echarts from "echarts";
import headerTitle from "@/components/headerTitle.vue";
export default {
  data() {
    return {
      emissionPledged: localStorage.getItem("emissionPledgedAnother"),
      carbonLimit: localStorage.getItem("carbonLimit"),
      ticketBuyback: localStorage.getItem("ticketBuyback"),
      ticketUnissued: localStorage.getItem("ticketUnissued"),
      companyName: localStorage.getItem("name"),
      chainName: localStorage.getItem("chain"),
      headerTitle: {
        largeTitle: "碳信管理",
        smallTitle: "企业碳信账户",
      },
      mychart: null,
      column: [
        {
          prop: "sender",
          label: "企业发行方",
          width: "",
        },
        {
          prop: "receiver",
          label: "收款方",
          width: "",
        },
        {
          prop: "address",
          label: "交易地址",
          width: "",
        },
        {
          prop: "time",
          label: "时间",
          width: "",
        },
        {
          prop: "amount",
          label: "数额",
          width: "",
        },
      ],
      tableData: [
        {
          sender: "核心企业名字",
          receiver: "减排链核属企业A",
          address: "123******EEE",
          time: "28 一月, 12.30 AM",
          amount: "￥￥￥￥",
        },
        {
          sender: "核心企业名字",
          receiver: "减排链核属企业A",
          address: "123******EEE",
          time: "28 一月, 12.30 AM",
          amount: "￥￥￥￥",
        },
      ],
    };
  },
  mounted() {
    if (!this.mychart) {
      this.mychart = echarts.init(document.getElementById("main"));
    }
    this.init();
  },
  methods: {
    refresh() {
      this.$message("已刷新数据");
    },
    init() {
      var option = {
        xAxis: [
          {
            type: "category",
            data: [
              "四月",
              "五月",
              "六月",
              "七月",
              "八月",
              "九月",
              "十月",
              "十一月",
            ],
            axisTick: {
              show: false,
            },
            axisLine: {
              show: false,
            },
            boundaryGap: false,
          },
        ],
        yAxis: [
          {
            type: "value",
            interval: 100, // 步长
            min: 0, // 起始
            max: 500, // 终止
            axisLabel: {
              show: true,
            },
            axisLine: {
              show: false,
            },
            axisTick: {
              show: false,
            },
            cap: "round",
            splitLine: {
              show: true,
              lineStyle: {
                type: "dashed",
                dashOffset: 200,
              },
            },
            grid: {
              left: "20",
            },
            nameTextStyle: {
              padding: [0, -30, 0, 20],
              fontSize: 16,
            },
          },
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
            data: [350, 400, 320, 150, 200, 140, 200, 360],
            type: "line",
            smooth: true,
            symbol: "none",
            lineStyle: {
              normal: {
                color: "#37e1cd",
                width: 3, //阴影的宽度
                shadowColor: "rgba(15,67,234,0.1)", //阴影的颜色值
                shadowBlur: 7,
                shadowOffsetY: 7,
              },
            },
          },
        ],
      };

      option && this.mychart.setOption(option);
      window.addEventListener("resize", function () {
        this.mychart.resize();
      });
    },
  },
  components: {
    headerTitle,
  },
};
</script>
<style scoped>
#main {
  display: block;
  margin: 20px 40px 0px 0px;
  width: 50%;
  height: 235px;
  background: #fff;
  border-radius: 25px;
}
.sub-content-body {
  margin: 30px 40px 40px;
}
.subcontent-title {
  color: #a0a3bd;
}

.subcontent-top-body {
  display: flex;
  height: 235px;
  margin-bottom: 40px;
  margin-top: 15px;
}
.subcontent-bellow-body {
  margin: 10px 0px 0px 0px;
}
.detail-card {
  height: 235px;
  border-radius: 25px;
  background: #fff;
  margin: 20px 0px 0px 0px;
  padding: 40px 40px 0px 60px;
}
.detail-card-title {
  font-size: 14px;
  color: #718ebf;
}
.refresh-data {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0px 20px 0px 20px;
}
.detail-card-content {
  font-size: 14px;
  font-weight: bold;
  color: #343c6a;
  padding-top: 5px;
}
.detail-card-margin {
  margin-top: 30px;
}

.el-table {
  border-radius: 25px;
}
::v-deep .el-table th.el-table__cell > .cell {
  font-size: 14px;
}
::v-deep .el-table .cell {
  font-size: 14px;
}
.refresh {
  font-size: 16px;

  cursor: pointer;
  color: #156a59;
}
</style>
