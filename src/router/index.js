import Vue from 'vue'
import VueRouter from 'vue-router'
// import layout from '@/layout'

Vue.use(VueRouter)


// const routes
export const routes = [
  {
    path: "/",
    component: () => import("@/views/login.vue"),
  },
  //控排链核心企业
  {
    path: "/index",
    component: () => import("@/layout/index"),
    meta: {
      title: "链属企业管理",
      icon: "el-icon-user",

    },
    children: [
      {
        path: "/kongpaiMainEnterprise/companyManagement/companylList",
        component: () => import("@/views/kongpaiMainEnterprise/companyManagement/companyList.vue"),
        meta: {
          title: "链属企业列表",
          
        },
      },
      {
        path: "/kongpaiMainEnterprise/companyManagement/approvalList",
        component: () => import("@/views/kongpaiMainEnterprise/companyManagement/approvalList.vue"),
        meta: {
          title: "减排计划申报",
        },
      },
      {
        path: "/kongpaiMainEnterprise/companyManagement/approvalListForm",
        component: () => import("@/views/kongpaiMainEnterprise/companyManagement/approvalListForm.vue"),
        meta: {
          title: "减排计划审核",
          
        },
      },
    ],
  },
  {
    path: "/kongpaiMainEnterprise/kongAccount",
    component: () => import("@/layout/index"),
    meta: {
      title: "控排链碳信账户",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/kongpaiMainEnterprise/kongAccount/accountBoard",
        component: () => import("@/views/kongpaiMainEnterprise/kongAccount/accountBoard.vue"),
        meta: {
          title: "账户信息",
        },
      },
      {
        path: "/kongpaiMainEnterprise/kongAccount/createCredit",
        component: () => import("@/views/kongpaiMainEnterprise/kongAccount/createCredit.vue"),
        meta: {
          title: "碳信创建",
        },
      },
      {
        path: "/kongpaiMainEnterprise/kongAccount/destroyCredit",
        component: () => import("@/views/kongpaiMainEnterprise/kongAccount/destroyCredit.vue"),
        meta: {
          title: "碳信销毁",
        },
      },
    ],
  },
  {
    path: "/kongpaiMainEnterprise/creditManagement",
    component: () => import("@/layout/index"),
    meta: {
      title: "碳信管理",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/kongpaiMainEnterprise/creditManagement/companyBoard",
        component: () => import("@/views/kongpaiMainEnterprise/creditManagement/companyBoard.vue"),
        meta: {
          title: "企业碳信账户",
        },
      },
      {
        path: "/kongpaiMainEnterprise/creditManagement/launchCredit",
        component: () => import("@/views/kongpaiMainEnterprise/creditManagement/launchCredit.vue"),
        meta: {
          title: "碳信发行",
        },
      },
      {
        path: "/kongpaiMainEnterprise/creditManagement/repoCredit",
        component: () => import("@/views/kongpaiMainEnterprise/creditManagement/repoCredit.vue"),
        meta: {
          title: "碳信回购",
        },
      },
    ],
  },
  {
    path: "/kongpaiMainEnterprise/pledgeManagement",
    component: () => import("@/layout/index"),
    meta: {
      title: "碳配额质押申请",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/kongpaiMainEnterprise/pledgeManagement/applicationList",
        component: () => import("@/views/kongpaiMainEnterprise/pledgeManagement/applicationList.vue"),
        meta: {
          title: "申请列表",
        },
      },
      {
        path: "/kongpaiMainEnterprise/pledgeManagement/pledgeApplication",
        component: () => import("@/views/kongpaiMainEnterprise/pledgeManagement/pledgeApplication.vue"),
        meta: {
          title: "质押申请",
        },
      },
      {
        path: "/kongpaiMainEnterprise/pledgeManagement/pledgeSigning",
        component: () => import("@/views/kongpaiMainEnterprise/pledgeManagement/pledgeSigning.vue"),
        meta: {
          title: "质押签约",
        },
      },
    ],
  },
  {
    path: "/kongpaiMainEnterprise/notificationList",
    component: () => import("@/layout/index"),
    meta: {
      title: "信息通知",
      icon: "el-icon-user",

    },
    children: [
      {
        path: "/kongpaiMainEnterprise/notificationList/notificationList",
        component: () => import("@/views/kongpaiMainEnterprise/notificationList/notificationList.vue"),
        meta: {
          title: "信息通知",
          icon: "el-icon-user",
        },
      },
    ]
  },
  //控排链链属企业
  {
    path: "/kongpaiAffliatedEnterprise/creditManagement",
    component: () => import("@/layout/index"),
    meta: {
      title: "碳信管理",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/kongpaiAffliatedEnterprise/creditManagement/companyBoard",
        component: () => import("@/views/kongpaiMainEnterprise/creditManagement/companyBoard.vue"),
        meta: {
          title: "企业碳信账户",
        },
      },
      {
        path: "/kongpaiAffliatedEnterprise/creditManagement/launchCredit",
        component: () => import("@/views/kongpaiMainEnterprise/creditManagement/launchCredit.vue"),
        meta: {
          title: "碳信发行",
        },
      },
      {
        path: "/kongpaiAffliatedEnterprise/creditManagement/repoCredit",
        component: () => import("@/views/kongpaiMainEnterprise/creditManagement/repoCredit.vue"),
        meta: {
          title: "碳信回购",
        },
      },
    ],
  },
  {
    path: "/kongpaiAffliatedEnterprise/pledgeManagement",
    component: () => import("@/layout/index"),
    meta: {
      title: "碳配额质押申请",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/kongpaiAffliatedEnterprise/pledgeManagement/applicationList",
        component: () => import("@/views/kongpaiMainEnterprise/pledgeManagement/applicationList.vue"),
        meta: {
          title: "申请列表",
        },
      },
      {
        path: "/kongpaiAffliatedEnterprise/pledgeManagement/pledgeApplication",
        component: () => import("@/views/kongpaiMainEnterprise/pledgeManagement/pledgeApplication.vue"),
        meta: {
          title: "质押申请",
        },
      },
      {
        path: "/kongpaiAffliatedEnterprise/pledgeManagement/pledgeSigning",
        component: () => import("@/views/kongpaiMainEnterprise/pledgeManagement/pledgeSigning.vue"),
        meta: {
          title: "质押签约",
        },
      },
    ],
  },
  {
    path: "/kongpaiAffliatedEnterprise/notificationList",
    component: () => import("@/layout/index"),
    meta: {
      title: "信息通知",
      icon: "el-icon-user",

    },
    children: [
      {
        path: "/kongpaiAffliatedEnterprise/notificationList/notificationList",
        component: () => import("@/views/kongpaiMainEnterprise/notificationList/notificationList.vue"),
        meta: {
          title: "信息通知",
          icon: "el-icon-user",
        },
      },
    ]
  },

  // 减排链核心企业
  {
    path: "/jianpaiMain",
    component: () => import("@/layout/index"),
    meta: {
      title: "链属企业管理",
      icon: "el-icon-user",

    },
    children: [
      {
        path: "/jianpaiMainEnterprise/companyManagement/companyList",
        component: () => import("@/views/jianpaiMainEnterprise/companyManagement/companyList.vue"),
        meta: {
          title: "链属企业列表",
          
        },
      },
    ],
  },
  {
    path: "/jianpaiMainEnterprise/creditManagement",
    component: () => import("@/layout/index"),
    meta: {
      title: "碳信管理",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/jianpaiMainEnterprise/creditManagement/companyBoard",
        component: () => import("@/views/kongpaiMainEnterprise/creditManagement/companyBoard.vue"),
        meta: {
          title: "企业碳信账户",
        },
      },
      {
        path: "/jianpaiMainEnterprise/creditManagement/transferCredit",
        component: () => import("@/views/jianpaiMainEnterprise/creditManagement/transferCredit.vue"),
        meta: {
          title: "碳信转让",
        },
      },
    ],
  },
  {
    path: "/jianpaiMainEnterprise/financingManagement",
    component: () => import("@/layout/index"),
    meta: {
      title: "融资管理",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/jianpaiMainEnterprise/financingManagement/financingList",
        component: () => import("@/views/jianpaiMainEnterprise/financingManagement/financingList.vue"),
        meta: {
          title: "融资列表",
        },
      },
      {
        path: "/jianpaiMainEnterprise/financingManagement/financingApplication",
        component: () => import("@/views/jianpaiMainEnterprise/financingManagement/financingApplication.vue"),
        meta: {
          title: "融资申请",
        },
      },
      {
        path: "/jianpaiMainEnterprise/financingManagement/financingSigning",
        component: () => import("@/views/jianpaiMainEnterprise/financingManagement/financingSigning.vue"),
        meta: {
          title: "融资签约",
        },
        
      },
    ],
  },
  {
    path: "/jianpaiMainEnterprise/taskManagement",
    component: () => import("@/layout/index"),
    meta: {
      title: "任务管理",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/jianpaiMainEnterprise/taskManagement/receiveCredit",
        component: () => import("@/views/jianpaiMainEnterprise/taskManagement/receiveCredit.vue"),
        meta: {
          title: "签收碳信",
        },
      },
      {
        path: "/jianpaiMainEnterprise/taskManagement/receivingDetails",
        component: () => import("@/views/jianpaiMainEnterprise/taskManagement/receivingDetails.vue"),
        meta: {
          title: "签收详情",
        },
      },
    ],
  },
  {
    path: "/jianpaiMainEnterprise/notificationList",
    component: () => import("@/layout/index"),
    meta: {
      title: "信息通知",
      icon: "el-icon-user",

    },
    children: [
      {
        path: "/jianpaiMainEnterprise/notificationList/notificationList",
        component: () => import("@/views/kongpaiMainEnterprise/notificationList/notificationList.vue"),
        meta: {
          title: "信息通知",
          icon: "el-icon-user",
        },
      },
    ]
  },

  // 减排链链属企业
  {
    path: "/jianpaiAffliatedEnterprise/creditManagement",
    component: () => import("@/layout/index"),
    meta: {
      title: "碳信管理",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/jianpaiAffliatedEnterprise/creditManagement/companyBoard",
        component: () => import("@/views/kongpaiMainEnterprise/creditManagement/companyBoard.vue"),
        meta: {
          title: "企业碳信账户",
        },
      },
      {
        path: "/jianpaiAffliatedEnterprise/creditManagement/transferCredit",
        component: () => import("@/views/jianpaiMainEnterprise/creditManagement/transferCredit.vue"),
        meta: {
          title: "碳信转让",
        },
      },
    ],
  },
  {
    path: "/jianpaiAffliatedEnterprise/financingManagement",
    component: () => import("@/layout/index"),
    meta: {
      title: "融资管理",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/jianpaiAffliatedEnterprise/financingManagement/financingList",
        component: () => import("@/views/jianpaiMainEnterprise/financingManagement/financingList.vue"),
        meta: {
          title: "融资列表",
        },
      },
      {
        path: "/jianpaiAffliatedEnterprise/financingManagement/financingApplication",
        component: () => import("@/views/jianpaiMainEnterprise/financingManagement/financingApplication.vue"),
        meta: {
          title: "融资申请",
        },
      },
      {
        path: "/jianpaiAffliatedEnterprise/financingManagement/financingSigning",
        component: () => import("@/views/jianpaiMainEnterprise/financingManagement/financingSigning.vue"),
        meta: {
          title: "融资签约",
        },
        
      },
    ],
  },
  {
    path: "/jianpaiAffliatedEnterprise/taskManagement",
    component: () => import("@/layout/index"),
    meta: {
      title: "任务管理",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/jianpaiAffliatedEnterprise/taskManagement/receiveCredit",
        component: () => import("@/views/jianpaiMainEnterprise/taskManagement/receiveCredit.vue"),
        meta: {
          title: "签收碳信",
        },
      },
      {
        path: "/jianpaiAffliatedEnterprise/taskManagement/receivingDetails",
        component: () => import("@/views/jianpaiMainEnterprise/taskManagement/receivingDetails.vue"),
        meta: {
          title: "签收详情",
        },
      },
    ],
  },
  {
    path: "/jianpaiAffliatedEnterprise/notificationList",
    component: () => import("@/layout/index"),
    meta: {
      title: "信息通知",
      icon: "el-icon-user",

    },
    children: [
      {
        path: "/jianpaiAffliatedEnterprise/notificationList/notificationList",
        component: () => import("@/views/kongpaiMainEnterprise/notificationList/notificationList.vue"),
        meta: {
          title: "信息通知",
          icon: "el-icon-user",
        },
      },
    ]
  },
  //金融机构
  {
    path: "/financeInstitute/taskManagement",
    component: () => import("@/layout/index"),
    meta: {
      title: "任务管理",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/financeInstitute/taskManagement/pledgeList",
        component: () => import("@/views/financeInstitute/taskManagement/pledgeList.vue"),
        meta: {
          title: "质押列表",
        },
      },
      {
        path: "/financeInstitute/taskManagement/PledgeApproval/:id",
        name: "PledgeApprovalDetail",
        component: () => import("@/views/financeInstitute/taskManagement/PledgeApproval.vue"),
        meta: {
          title: "质押审批",
        },
      },
      {
        path: "/financeInstitute/taskManagement/PledgeSigning/:id",
        name: "PledgeSigningDetail",
        component: () => import("@/views/financeInstitute/taskManagement/PledgeSigning.vue"),
        meta: {
          title: "质押签订",
        },
      },
    ],
  },
  {
    path: "/financeInstitute/financingManagement",
    component: () => import("@/layout/index"),
    meta: {
      title: "融资管理",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/financeInstitute/financingManagement/financingList",
        component: () => import("@/views/financeInstitute/financingManagement/financingList.vue"),
        meta: {
          title: "融资列表",
        },
      },
      {
        path: "/financeInstitute/financingManagement/factoringApproval",
        component: () => import("@/views/financeInstitute/financingManagement/factoringApproval.vue"),
        meta: {
          title: "保理审核",
        },
      },
      {
        path: "/financeInstitute/financingManagement/factoringBuying",
        component: () => import("@/views/financeInstitute/financingManagement/factoringBuying.vue"),
        meta: {
          title: "保理买入",
        },
      },
    ],
    
  },
  {
    path: "/financeInstitute/notificationList",
    component: () => import("@/layout/index"),
    meta: {
      title: "信息通知",
      icon: "el-icon-user",

    },
    children: [
      {
        path: "/financeInstitute/notificationList/notificationList",
        component: () => import("@/views/kongpaiMainEnterprise/notificationList/notificationList.vue"),
        meta: {
          title: "信息通知",
          icon: "el-icon-user",
        },
      },
    ]
  },
  

  

]

//登录判断
export function getUserRoutes(accountType) {
  let indexList = []
  switch(accountType){
    case "1":
      indexList = [1,2,3,4,5]
    break;

    case "2":
      indexList = [6, 7, 8]
    break;

    case "3":
      indexList = [9,10,11,12,13]
    break;

    case "4":
      indexList = [14,15,16,17]
    break;

    case "0":
      indexList = [18,19,20]
    break;
  }

  if(indexList.length == 0) return routes;
  console.log("test")
  return indexList.map((index) => routes[index]);
}

export const router = new VueRouter({
  routes,
});



// const routeform = new VueRouter({
//   routeform
// })

// export default router
