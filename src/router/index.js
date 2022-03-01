import Vue from 'vue'
import VueRouter from 'vue-router'
// import layout from '@/layout'

Vue.use(VueRouter)
// const routes
export const routes = [
 
  {
    path: "/",
    component: () => import("@/layout/index"),
    meta: {
      title: "链属企业管理",
      icon: "el-icon-user",
    },
    children: [
      {
        path: "/kongpaiMainEnterprise/companyManagement/approvalList",
        component: () => import("@/views/kongpaiMainEnterprise/companyManagement/companyList.vue"),
        meta: {
          title: "链属企业列表",
        },
      },
      {
        path: "/kongpaiMainEnterprise/companyManagement/companyList",
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
]
  // {
    // path: '/',
    // component: ()=>import('@/layout'),
    // children:[

      
      // {
      //   path: '/kongpaiMainEnterprise/p1-company-management-list',
      //   component: ()=>import('@/views/kongpaiMainEnterprise/p1-company-management-list')
      // },
      // {
      //   path: '/kongpaiMainEnterprise/p2-company-management-approval',
      //   component: ()=>import('@/views/kongpaiMainEnterprise/p2-company-management-approval')
      // },
      // {
      //   path: '/kongpaiMainEnterprise/p2-01-company-management-approval-form',
      //   component: ()=>import('@/views/kongpaiMainEnterprise/p2-01-company-management-approval-form')
      // },
      // {
      //   path: '/kongpaiMainEnterprise/p3-kong-account-detail',
      //   component: ()=>import('@/views/kongpaiMainEnterprise/p3-kong-account-detail')
      // },
      // {
      //   path: '/kongpaiMainEnterprise/p4-carbon-credit-created',
      //   component: ()=>import('@/views/kongpaiMainEnterprise/p4-carbon-credit-created')
      // },
      // {
      //   path: '/kongpaiMainEnterprise/p5-carbon-credit-destroyed',
      //   component: ()=>import('@/views/kongpaiMainEnterprise/p5-carbon-credit-destroyed')
      // },
      // {
      //   path: '/kongpaiMainEnterprise/p6-company-carbon-credit-account-detail',
      //   component: ()=>import('@/views/kongpaiMainEnterprise/p6-company-carbon-credit-account-detail')
      // },
      // {
      //   path: '/kongpaiMainEnterprise/p7-carbon-credit-launching',
      //   component: ()=>import('@/views/kongpaiMainEnterprise/p7-carbon-credit-launching')
      // },
      // {
      //   path: '/kongpaiMainEnterprise/p8-carbon-credit-repo-list',
      //   component: ()=>import('@/views/kongpaiMainEnterprise/p8-carbon-credit-repo-list')
      // },
      
      // {
      //   path: '/kongpaiMainEnterprise/p9-pledge-application',
      //   component: ()=>import('@/views/kongpaiMainEnterprise/p9-pledge-application')
      // },
      // {
      //   path: '/kongpaiMainEnterprise/p10-notifications-list',
      //   component: ()=>import('@/views/kongpaiMainEnterprise/p10-notifications-list')
      // },
    // ]
  // },
  // {
    // path: '/index2',
    // component: ()=>import('@/layout/index2'),
    // children:[
    //   {
    //     path: '/kongpaiChainEnterprise/p6-company-carbon-credit-account-detail',
    //     component: ()=>import('@/views/kongpaiChainEnterprise/p6-company-carbon-credit-account-detail')
    //   },
    //   {
    //     path: '/kongpaiChainEnterprise/p7-carbon-credit-launching',
    //     component: ()=>import('@/views/kongpaiChainEnterprise/p7-carbon-credit-launching')
    //   },
    //   {
    //     path: '/kongpaiChainEnterprise/p8-carbon-credit-repo-list',
    //     component: ()=>import('@/views/kongpaiChainEnterprise/p8-carbon-credit-repo-list')
    //   },
      
    //   {
    //     path: '/kongpaiChainEnterprise/p9-pledge-application',
    //     component: ()=>import('@/views/kongpaiChainEnterprise/p9-pledge-application')
    //   },
    //   {
    //     path: '/kongpaiChainEnterprise/p10-notifications-list',
    //     component: ()=>import('@/views/kongpaiChainEnterprise/p10-notifications-list')
    //   },
    // ]
   
  // },
  // {
    // path: '/index3',
    // component: ()=>import('@/layout/index3'),
    // children:[
    //   {
    //     path: '/jianpaiMainChainEnterprise/p1-company-management-list',
    //     component: ()=>import('@/views/jianpaiMainChainEnterprise/p1-company-management-list')
    //   },
    //   {
    //     path: '/jianpaiMainChainEnterprise/p2-company-carbon-credit-account-detail',
    //     component: ()=>import('@/views/jianpaiMainChainEnterprise/p2-company-carbon-credit-account-detail')
    //   },
    //   {
    //     path: '/jianpaiMainChainEnterprise/p3-carbon-credit-transfer',
    //     component: ()=>import('@/views/jianpaiMainChainEnterprise/p3-carbon-credit-transfer')
    //   },
    //   {
    //     path: '/jianpaiMainChainEnterprise/p4-financing-application',
    //     component: ()=>import('@/views/jianpaiMainChainEnterprise/p4-financing-application')
    //   },
    //   {
    //     path: '/jianpaiMainChainEnterprise/p5-carbon-receiving-task',
    //     component: ()=>import('@/views/jianpaiMainChainEnterprise/p5-carbon-receiving-task')
    //   },
    //   {
    //     path: '/jianpaiMainChainEnterprise/p5-1taskDetail',
    //     component: ()=>import('@/views/jianpaiMainChainEnterprise/p5-1taskDetail')
    //   },
    //   {
    //     path: '/jianpaiMainChainEnterprise/p6-notifications-list',
    //     component: ()=>import('@/views/jianpaiMainChainEnterprise/p6-notifications-list')
    //   }

     
    // ]
   
  // },

  // {
    // path: '/index4',
    // component: ()=>import('@/layout/index4'),
    // children:[
    //   {
    //     path: '/jianpaiLinkedEnterprise/p2-company-carbon-credit-account-detail',
    //     component: ()=>import('@/views/jianpaiLinkedEnterprise/p2-company-carbon-credit-account-detail')
    //   },
    //   {
    //     path: '/jianpaiLinkedEnterprise/p3-carbon-credit-transfer',
    //     component: ()=>import('@/views/jianpaiLinkedEnterprise/p3-carbon-credit-transfer')
    //   },
    //   {
    //     path: '/jianpaiLinkedEnterprise/p4-financing-application',
    //     component: ()=>import('@/views/jianpaiLinkedEnterprise/p4-financing-application')
    //   },
    //   {
    //     path: '/jianpaiLinkedEnterprise/p5-carbon-receiving-task',
    //     component: ()=>import('@/views/jianpaiLinkedEnterprise/p5-carbon-receiving-task')
    //   },
    //   {
    //     path: '/jianpaiLinkedEnterprise/p5-1taskDetail',
    //     component: ()=>import('@/views/jianpaiLinkedEnterprise/p5-1taskDetail')
    //   },
    //   {
    //     path: '/jianpaiLinkedEnterprise/p6-notifications-list',
    //     component: ()=>import('@/views/jianpaiLinkedEnterprise/p6-notifications-list')
    //   }

     
    // ]
   
  // },
  // {
  //   path: '/index5',
  //   component: ()=>import('@/layout/index5'),
  //   children:[
  //     {
  //       path: '/financeInstitute/PledgeAproval',
  //       component: ()=>import('@/views/financeInstitute/PledgeAproval')
  //     },
  //     {
  //       path: '/financeInstitute/PledgeAprovalDetails',
  //       component: ()=>import('@/views/financeInstitute/PledgeAprovalDetails')
  //     },
  //     {
  //       path: '/financeInstitute/PledgeSigning',
  //       component: ()=>import('@/views/financeInstitute/PledgeSigning')
  //     },
  //     {
  //       path: '/financeInstitute/PledgeSigningDetails',
  //       component: ()=>import('@/views/financeInstitute/PledgeSigningDetails')
  //     },
  //     {
  //       path: '/financeInstitute/ComplianceReview',
  //       component: ()=>import('@/views/financeInstitute/ComplianceReview')
  //     },
  //     {
  //       path: '/financeInstitute/ComplianceReviewDetails',
  //       component: ()=>import('@/views/financeInstitute/ComplianceReviewDetails')
  //     },
  //     {
  //       path: '/financeInstitute/FactoringBuying',
  //       component: ()=>import('@/views/financeInstitute/FactoringBuying')
  //     },
  //     {
  //       path: '/financeInstitute/notificationList',
  //       component: ()=>import('@/views/financeInstitute/notificationList')
  //     }
  //   ]
   
  // },
// const routeform=[ {
  
//     path: '/financeInstitute/notificationList',
//     component: ()=>import('@/views/financeInstitute/notificationList')

// }
// ]
export const router = new VueRouter({
  routes,
});

// const routeform = new VueRouter({
//   routeform
// })

// export default router
