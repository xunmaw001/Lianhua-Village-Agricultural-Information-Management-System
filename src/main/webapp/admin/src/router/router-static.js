import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import address from '@/views/modules/address/list'
    import cart from '@/views/modules/cart/list'
    import chanpin from '@/views/modules/chanpin/list'
    import chanpinCollection from '@/views/modules/chanpinCollection/list'
    import chanpinCommentback from '@/views/modules/chanpinCommentback/list'
    import chanpinOrder from '@/views/modules/chanpinOrder/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import gonggao from '@/views/modules/gonggao/list'
    import jishu from '@/views/modules/jishu/list'
    import nongzi from '@/views/modules/nongzi/list'
    import nongziOrder from '@/views/modules/nongziOrder/list'
    import yonghu from '@/views/modules/yonghu/list'
    import zhongzhihu from '@/views/modules/zhongzhihu/list'
    import config from '@/views/modules/config/list'
    import dictionaryChanpin from '@/views/modules/dictionaryChanpin/list'
    import dictionaryChanpinCollection from '@/views/modules/dictionaryChanpinCollection/list'
    import dictionaryChanpinOrder from '@/views/modules/dictionaryChanpinOrder/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryIsdefault from '@/views/modules/dictionaryIsdefault/list'
    import dictionaryJishu from '@/views/modules/dictionaryJishu/list'
    import dictionaryNongzi from '@/views/modules/dictionaryNongzi/list'
    import dictionaryNongziOrder from '@/views/modules/dictionaryNongziOrder/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryChanpin',
        name: '农产品类型',
        component: dictionaryChanpin
    }
    ,{
        path: '/dictionaryChanpinCollection',
        name: '收藏表类型',
        component: dictionaryChanpinCollection
    }
    ,{
        path: '/dictionaryChanpinOrder',
        name: '订单类型',
        component: dictionaryChanpinOrder
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryIsdefault',
        name: '是否默认地址',
        component: dictionaryIsdefault
    }
    ,{
        path: '/dictionaryJishu',
        name: '农作物类型',
        component: dictionaryJishu
    }
    ,{
        path: '/dictionaryNongzi',
        name: '农资类型',
        component: dictionaryNongzi
    }
    ,{
        path: '/dictionaryNongziOrder',
        name: '订单类型',
        component: dictionaryNongziOrder
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/address',
        name: '收货地址',
        component: address
      }
    ,{
        path: '/cart',
        name: '购物车',
        component: cart
      }
    ,{
        path: '/chanpin',
        name: '农产品',
        component: chanpin
      }
    ,{
        path: '/chanpinCollection',
        name: '农产品收藏',
        component: chanpinCollection
      }
    ,{
        path: '/chanpinCommentback',
        name: '农产品评价',
        component: chanpinCommentback
      }
    ,{
        path: '/chanpinOrder',
        name: '农产品订单',
        component: chanpinOrder
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/jishu',
        name: '农业技术',
        component: jishu
      }
    ,{
        path: '/nongzi',
        name: '农资',
        component: nongzi
      }
    ,{
        path: '/nongziOrder',
        name: '农资订单',
        component: nongziOrder
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/zhongzhihu',
        name: '种植户',
        component: zhongzhihu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
