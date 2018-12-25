<template>
  <div class="book">

    <div class="page">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/1.png">
    </div>

    <div class="page">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/2.png">
    </div>

    <div class="page page3">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/3.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr>
            <td class="label">姓名</td>
            <td class="value">{{data.name}}</td>
            <td class="label">性别</td>
            <td class="value">{{data.gender}}</td>
            <td class="label">出生日期</td>
            <td class="value">{{data.birthday | formatDate("yyyy-MM-dd")}}</td>
          </tr>
          <tr>
            <td class="label">血型</td>
            <td class="value">{{data.bloodGroup}}</td>
            <td class="label">Rh抗原</td>
            <td class="value">{{data.rhAntigen}}</td>
            <td class="label">&nbsp;</td>
            <td class="value">&nbsp;</td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="box">
        <div class="name">{{data.name}}(参数ID：{{data.id}})</div>
        <div class="item">
          <span class="label">联系电话：</span><span class="value">{{data.mobile}}</span>
        </div>
        <div class="item">
          <span class="label">出生日期：</span><span class="value">{{data.birthday | formatDate("yyyy-MM-dd")}}</span>
        </div>
        <div class="item">
        </div>
        <div class="item">
          <span class="label">亚健康检测编码：</span><span class="value">{{data.page2Code}}</span>
        </div>
        <div class="item">
          <span class="label">客 户 经 理：</span><span class="value">{{data.salesName}}</span>
        </div>
        <div class="item">
          <span class="label">公 司 名 称：</span><span class="value">{{data.companyName}}</span>
        </div>
        <div class="jzcode item">
          <span class="label">报告生成日期：</span><span class="value">{{data.createdTime | formatDate("yyyy年MM月dd日")}}</span>
        </div>
      </div>

      <div class="page-no">
        01
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/4.png">
      <div class="page-no">
        02
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page5">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/5.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">疾病风险</td>
            <td class="head-td2">压力器官</td>
            <td class="head-td3">结果</td>
            <td class="head-td4">风险等级</td>
          </tr>
          <tr class="body" v-for="item of data.focusDisease">
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box1">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                {{item.riskLevel + "级"}}
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        03
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page6">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/6.png">

      <div class="risk risk3" v-bind:class="data.riskValueMap.riskValue3Class"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue3+'pt'}"></div>
      <div class="risk risk4" v-bind:class="data.riskValueMap.riskValue4Class"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue4+'pt'}"></div>
      <div class="risk risk5" v-bind:class="data.riskValueMap.riskValue5Class"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue5+'pt'}"></div>
      <div class="risk risk6" v-bind:class="data.riskValueMap.riskValue6Class"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue6+'pt'}"></div>
      <div class="risk risk7" v-bind:class="data.riskValueMap.riskValue7Class"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue7+'pt'}"></div>
      <div class="risk risk8" v-bind:class="data.riskValueMap.riskValue8Class"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue8+'pt'}"></div>
      <div class="risk risk9" v-bind:class="data.riskValueMap.riskValue9Class"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue9+'pt'}"></div>
      <div class="risk risk10" v-bind:class="data.riskValueMap.riskValue10Class"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue10+'pt'}"></div>
      <div class="risk risk11" v-bind:class="data.riskValueMap.riskValue11Class"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue11+'pt'}"></div>

      <div class="risk-icon risk-icon3"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue3+9+'pt'}">
        <img src="~/assets/module2/page2/level-icon1.png" v-if="data.riskValueMap.riskValue3Class.level1">
        <img src="~/assets/module2/page2/level-icon2.png" v-if="data.riskValueMap.riskValue3Class.level2">
        <img src="~/assets/module2/page2/level-icon3.png" v-if="data.riskValueMap.riskValue3Class.level3">
        <img src="~/assets/module2/page2/level-icon4.png" v-if="data.riskValueMap.riskValue3Class.level4">
      </div>

      <div class="risk-icon risk-icon4"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue4+9+'pt'}">
        <img src="~/assets/module2/page2/level-icon1.png" v-if="data.riskValueMap.riskValue4Class.level1">
        <img src="~/assets/module2/page2/level-icon2.png" v-if="data.riskValueMap.riskValue4Class.level2">
        <img src="~/assets/module2/page2/level-icon3.png" v-if="data.riskValueMap.riskValue4Class.level3">
        <img src="~/assets/module2/page2/level-icon4.png" v-if="data.riskValueMap.riskValue4Class.level4">
      </div>

      <div class="risk-icon risk-icon5"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue5+9+'pt'}">
        <img src="~/assets/module2/page2/level-icon1.png" v-if="data.riskValueMap.riskValue5Class.level1">
        <img src="~/assets/module2/page2/level-icon2.png" v-if="data.riskValueMap.riskValue5Class.level2">
        <img src="~/assets/module2/page2/level-icon3.png" v-if="data.riskValueMap.riskValue5Class.level3">
        <img src="~/assets/module2/page2/level-icon4.png" v-if="data.riskValueMap.riskValue5Class.level4">
      </div>

      <div class="risk-icon risk-icon6"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue6+9+'pt'}">
        <img src="~/assets/module2/page2/level-icon1.png" v-if="data.riskValueMap.riskValue6Class.level1">
        <img src="~/assets/module2/page2/level-icon2.png" v-if="data.riskValueMap.riskValue6Class.level2">
        <img src="~/assets/module2/page2/level-icon3.png" v-if="data.riskValueMap.riskValue6Class.level3">
        <img src="~/assets/module2/page2/level-icon4.png" v-if="data.riskValueMap.riskValue6Class.level4">
      </div>

      <div class="risk-icon risk-icon7"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue7+9+'pt'}">
        <img src="~/assets/module2/page2/level-icon1.png" v-if="data.riskValueMap.riskValue7Class.level1">
        <img src="~/assets/module2/page2/level-icon2.png" v-if="data.riskValueMap.riskValue7Class.level2">
        <img src="~/assets/module2/page2/level-icon3.png" v-if="data.riskValueMap.riskValue7Class.level3">
        <img src="~/assets/module2/page2/level-icon4.png" v-if="data.riskValueMap.riskValue7Class.level4">
      </div>

      <div class="risk-icon risk-icon8"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue8+9+'pt'}">
        <img src="~/assets/module2/page2/level-icon1.png" v-if="data.riskValueMap.riskValue8Class.level1">
        <img src="~/assets/module2/page2/level-icon2.png" v-if="data.riskValueMap.riskValue8Class.level2">
        <img src="~/assets/module2/page2/level-icon3.png" v-if="data.riskValueMap.riskValue8Class.level3">
        <img src="~/assets/module2/page2/level-icon4.png" v-if="data.riskValueMap.riskValue8Class.level4">
      </div>

      <div class="risk-icon risk-icon9"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue9+9+'pt'}">
        <img src="~/assets/module2/page2/level-icon1.png" v-if="data.riskValueMap.riskValue9Class.level1">
        <img src="~/assets/module2/page2/level-icon2.png" v-if="data.riskValueMap.riskValue9Class.level2">
        <img src="~/assets/module2/page2/level-icon3.png" v-if="data.riskValueMap.riskValue9Class.level3">
        <img src="~/assets/module2/page2/level-icon4.png" v-if="data.riskValueMap.riskValue9Class.level4">
      </div>

      <div class="risk-icon risk-icon10"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue10+9+'pt'}">
        <img src="~/assets/module2/page2/level-icon1.png" v-if="data.riskValueMap.riskValue10Class.level1">
        <img src="~/assets/module2/page2/level-icon2.png" v-if="data.riskValueMap.riskValue10Class.level2">
        <img src="~/assets/module2/page2/level-icon3.png" v-if="data.riskValueMap.riskValue10Class.level3">
        <img src="~/assets/module2/page2/level-icon4.png" v-if="data.riskValueMap.riskValue10Class.level4">
      </div>

      <div class="risk-icon risk-icon11"
           v-bind:style="{height:200/100*data.riskValueMap.riskValue11+9+'pt'}">
        <img src="~/assets/module2/page2/level-icon1.png" v-if="data.riskValueMap.riskValue11Class.level1">
        <img src="~/assets/module2/page2/level-icon2.png" v-if="data.riskValueMap.riskValue11Class.level2">
        <img src="~/assets/module2/page2/level-icon3.png" v-if="data.riskValueMap.riskValue11Class.level3">
        <img src="~/assets/module2/page2/level-icon4.png" v-if="data.riskValueMap.riskValue11Class.level4">
      </div>

      <div class="page-no">
        04
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-3-1">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-3-1.png">
      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">疾病风险</td>
            <td class="head-td2">压力器官</td>
            <td class="head-td3">结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="item of data.diseaseItemListMap.SYSTEM_FOCUS_3">
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        05
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-3-2">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-3-2.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">疾病风险</td>
            <td class="head-td3">压力器官</td>
            <td class="head-td4">结果</td>
            <td class="head-td5">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ALERT_3">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        06
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-3-3">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-3-3.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">组织风险</td>
            <td class="head-td3">风险结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ORGAN_3">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        07
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-3-4">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-3-4.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">生化项目</td>
            <td class="head-td3">相关疾病</td>
            <td class="head-td4">风险结果</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.BIOCHEMISTRY_3">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.detail}}</td>
            <td class="body-td4">
              <div class="dot-box3">
                {{item.value}}&nbsp;
                <img class="dot" src="~/assets/module2/page2/arrow-down.png" v-if="item.itemDValue === -1">
                <img class="dot" src="~/assets/module2/page2/arrow-up.png" v-if="item.itemDValue === 1">
                <img class="dot" src="~/assets/module2/page2/healthy.png" v-if="item.itemDValue === 0">
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        08
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-4-1">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-4-1.png">
      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">疾病风险</td>
            <td class="head-td2">压力器官</td>
            <td class="head-td3">结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="item of data.diseaseItemListMap.SYSTEM_FOCUS_4">
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
      <div class="page-no">
        09
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-4-2">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-4-2.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">疾病风险</td>
            <td class="head-td3">压力器官</td>
            <td class="head-td4">结果</td>
            <td class="head-td5">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ALERT_4">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        10
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-4-3">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-4-3.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">组织风险</td>
            <td class="head-td3">风险结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ORGAN_4">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        11
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-4-4">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-4-4.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">生化项目</td>
            <td class="head-td3">相关疾病</td>
            <td class="head-td4">风险结果</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.BIOCHEMISTRY_4">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.detail}}</td>
            <td class="body-td4">
              <div class="dot-box3">
                {{item.value}}&nbsp;
                <img class="dot" src="~/assets/module2/page2/arrow-down.png" v-if="item.itemDValue === -1">
                <img class="dot" src="~/assets/module2/page2/arrow-up.png" v-if="item.itemDValue === 1">
                <img class="dot" src="~/assets/module2/page2/healthy.png" v-if="item.itemDValue === 0">
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        12
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-5-1">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-5-1.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">疾病风险</td>
            <td class="head-td2">压力器官</td>
            <td class="head-td3">结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="item of data.diseaseItemListMap.SYSTEM_FOCUS_5">
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        13
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-5-2">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-5-2.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">疾病风险</td>
            <td class="head-td3">压力器官</td>
            <td class="head-td4">结果</td>
            <td class="head-td5">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ALERT_5">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        14
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-5-3">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-5-3.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">组织风险</td>
            <td class="head-td3">风险结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ORGAN_5">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        15
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-5-4">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-5-4.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">生化项目</td>
            <td class="head-td3">相关疾病</td>
            <td class="head-td4">风险结果</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.BIOCHEMISTRY_5">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.detail}}</td>
            <td class="body-td4">
              <div class="dot-box3">
                {{item.value}}&nbsp;
                <img class="dot" src="~/assets/module2/page2/arrow-down.png" v-if="item.itemDValue === -1">
                <img class="dot" src="~/assets/module2/page2/arrow-up.png" v-if="item.itemDValue === 1">
                <img class="dot" src="~/assets/module2/page2/healthy.png" v-if="item.itemDValue === 0">
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        16
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-6-1">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-6-1.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">疾病风险</td>
            <td class="head-td2">压力器官</td>
            <td class="head-td3">结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="item of data.diseaseItemListMap.SYSTEM_FOCUS_6">
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        17
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-6-2">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-6-2.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">疾病风险</td>
            <td class="head-td3">压力器官</td>
            <td class="head-td4">结果</td>
            <td class="head-td5">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ALERT_6">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        18
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-6-3">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-6-3.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">组织风险</td>
            <td class="head-td3">风险结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ORGAN_6">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        19
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-6-4">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-6-4.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">生化项目</td>
            <td class="head-td3">相关疾病</td>
            <td class="head-td4">风险结果</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.BIOCHEMISTRY_6">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.detail}}</td>
            <td class="body-td4">
              <div class="dot-box3">
                {{item.value}}&nbsp;
                <img class="dot" src="~/assets/module2/page2/arrow-down.png" v-if="item.itemDValue === -1">
                <img class="dot" src="~/assets/module2/page2/arrow-up.png" v-if="item.itemDValue === 1">
                <img class="dot" src="~/assets/module2/page2/healthy.png" v-if="item.itemDValue === 0">
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        20
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-7-1">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-7-1.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">疾病风险</td>
            <td class="head-td2">压力器官</td>
            <td class="head-td3">结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="item of data.diseaseItemListMap.SYSTEM_FOCUS_7">
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        21
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-7-2">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-7-2.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">疾病风险</td>
            <td class="head-td3">压力器官</td>
            <td class="head-td4">结果</td>
            <td class="head-td5">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ALERT_7">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        22
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-7-3">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-7-3.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">组织风险</td>
            <td class="head-td3">风险结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ORGAN_7">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        22
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-7-4">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-7-4.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">生化项目</td>
            <td class="head-td3">相关疾病</td>
            <td class="head-td4">风险结果</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.BIOCHEMISTRY_7">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.detail}}</td>
            <td class="body-td4">
              <div class="dot-box3">
                {{item.value}}&nbsp;
                <img class="dot" src="~/assets/module2/page2/arrow-down.png" v-if="item.itemDValue === -1">
                <img class="dot" src="~/assets/module2/page2/arrow-up.png" v-if="item.itemDValue === 1">
                <img class="dot" src="~/assets/module2/page2/healthy.png" v-if="item.itemDValue === 0">
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        24
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-8-1">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-8-1.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">疾病风险</td>
            <td class="head-td2">压力器官</td>
            <td class="head-td3">结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="item of data.diseaseItemListMap.SYSTEM_FOCUS_8">
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        25
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-8-2">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-8-2.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">疾病风险</td>
            <td class="head-td3">压力器官</td>
            <td class="head-td4">结果</td>
            <td class="head-td5">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ALERT_8">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        26
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-8-3">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-8-3.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">组织风险</td>
            <td class="head-td3">风险结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ORGAN_8">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        27
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-8-4">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-8-4.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">生化项目</td>
            <td class="head-td3">相关疾病</td>
            <td class="head-td4">风险结果</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.BIOCHEMISTRY_8">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.detail}}</td>
            <td class="body-td4">
              <div class="dot-box3">
                {{item.value}}&nbsp;
                <img class="dot" src="~/assets/module2/page2/arrow-down.png" v-if="item.itemDValue === -1">
                <img class="dot" src="~/assets/module2/page2/arrow-up.png" v-if="item.itemDValue === 1">
                <img class="dot" src="~/assets/module2/page2/healthy.png" v-if="item.itemDValue === 0">
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        28
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-9-1">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-9-1.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">疾病风险</td>
            <td class="head-td2">压力器官</td>
            <td class="head-td3">结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="item of data.diseaseItemListMap.SYSTEM_FOCUS_9">
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        29
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-9-2">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-9-2.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">疾病风险</td>
            <td class="head-td3">压力器官</td>
            <td class="head-td4">结果</td>
            <td class="head-td5">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ALERT_9">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        30
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-9-3">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-9-3.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">组织风险</td>
            <td class="head-td3">风险结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ORGAN_9">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        31
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page  page-7-9-4">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-9-4.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">生化项目</td>
            <td class="head-td3">相关疾病</td>
            <td class="head-td4">风险结果</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.BIOCHEMISTRY_9">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.detail}}</td>
            <td class="body-td4">
              <div class="dot-box3">
                {{item.value}}&nbsp;
                <img class="dot" src="~/assets/module2/page2/arrow-down.png" v-if="item.itemDValue === -1">
                <img class="dot" src="~/assets/module2/page2/arrow-up.png" v-if="item.itemDValue === 1">
                <img class="dot" src="~/assets/module2/page2/healthy.png" v-if="item.itemDValue === 0">
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        32
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-10-1">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-10-1.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">疾病风险</td>
            <td class="head-td2">压力器官</td>
            <td class="head-td3">结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="item of data.diseaseItemListMap.SYSTEM_FOCUS_10">
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        33
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-10-2">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-10-2.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">疾病风险</td>
            <td class="head-td3">压力器官</td>
            <td class="head-td4">结果</td>
            <td class="head-td5">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ALERT_10">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        34
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-10-3">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-10-3.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">组织风险</td>
            <td class="head-td3">风险结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ORGAN_10">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        35
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-10-4">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-10-4.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">生化项目</td>
            <td class="head-td3">相关疾病</td>
            <td class="head-td4">风险结果</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.BIOCHEMISTRY_10">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.detail}}</td>
            <td class="body-td4">
              <div class="dot-box3">
                {{item.value}}&nbsp;
                <img class="dot" src="~/assets/module2/page2/arrow-down.png" v-if="item.itemDValue === -1">
                <img class="dot" src="~/assets/module2/page2/arrow-up.png" v-if="item.itemDValue === 1">
                <img class="dot" src="~/assets/module2/page2/healthy.png" v-if="item.itemDValue === 0">
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        36
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-11-1">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-11-1.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">疾病风险</td>
            <td class="head-td2">压力器官</td>
            <td class="head-td3">结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="item of data.diseaseItemListMap.SYSTEM_FOCUS_11">
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        37
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-11-2">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-11-2.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">疾病风险</td>
            <td class="head-td3">压力器官</td>
            <td class="head-td4">结果</td>
            <td class="head-td5">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ALERT_11">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}风险</td>
            <td>{{item.detail ? item.detail:"/"}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        38
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-11-3">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-11-3.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">组织风险</td>
            <td class="head-td3">风险结果</td>
            <td class="head-td4">风险标识</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.ORGAN_11">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.value}}</td>
            <td>
              <div class="dot-box2">
                <img class="dot" src="~/assets/module2/page2/level-dot1.png" v-if="item.riskLevel === 1">
                <img class="dot" src="~/assets/module2/page2/level-dot2.png" v-if="item.riskLevel === 2">
                <img class="dot" src="~/assets/module2/page2/level-dot3.png" v-if="item.riskLevel === 3">
                <img class="dot" src="~/assets/module2/page2/level-dot4.png" v-if="item.riskLevel === 4">
                &nbsp;
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        39
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page page-7-11-4">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/7-11-4.png">

      <div class="table-box">
        <table>
          <tbody>
          <tr class="head">
            <td class="head-td1">序号</td>
            <td class="head-td2">生化项目</td>
            <td class="head-td3">相关疾病</td>
            <td class="head-td4">风险结果</td>
          </tr>
          <tr class="body" v-for="(item,$index) of data.diseaseItemListMap.BIOCHEMISTRY_11">
            <td>{{$index + 1}}</td>
            <td>{{item.diseaseName}}</td>
            <td>{{item.detail}}</td>
            <td class="body-td4">
              <div class="dot-box3">
                {{item.value}}&nbsp;
                <img class="dot" src="~/assets/module2/page2/arrow-down.png" v-if="item.itemDValue === -1">
                <img class="dot" src="~/assets/module2/page2/arrow-up.png" v-if="item.itemDValue === 1">
                <img class="dot" src="~/assets/module2/page2/healthy.png" v-if="item.itemDValue === 0">
              </div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>

      <div class="page-no">
        40
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/8.png">
      <div class="page-no">
        41
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/9.png">
      <div class="page-no">
        42
        <div class="left-line"></div>
        <div class="right-line"></div>
      </div>
    </div>

    <div class="page">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/10.png">
    </div>

    <div class="page">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page2/11.png">
    </div>
  </div>
</template>

<script>
  import {mapState} from "vuex"

  export default {
    async fetch({store, route}) {
      await store.dispatch('module2-page2/GET_DATA', route.params.id);
    },
    computed: {
      ...mapState('module2-page2', {
        data: state => state.data
      })
    },

  }
</script>
<style scoped lang="less">

  .page-no {
    position: absolute;
    bottom: 7pt;
    text-align: center;
    font-weight: normal;
    font-size: 14pt;
    width: 100%;
    .left-line, .right-line {
      position: absolute;
      top: 6.5pt;
      display: inline-block;
      width: 22pt;
      border-top: 1.1pt solid #000;
    }
    .left-line {
      left: 260pt;
    }
    .right-line {
      left: 310pt;
    }
  }

  .table-box {
    position: absolute;
    font-weight: normal;
    text-align: center;
    table {
      width: 100%;
      tr th, tr td {
        border: 1pt solid #e5e5e5;
      }
      .head {
        font-weight: bold;
      }
      .dot-box1 {
        position: relative;
        display: inline-block;
        padding-left: 13pt;
        img {
          position: absolute;
          top: 2.2pt;
          left: 0;
        }
      }
      .dot-box2 {
        position: relative;
        display: inline-block;
        img {
          position: absolute;
          top: 2.5pt;
          left: -6px;
        }
      }
      .dot-box3 {
        position: relative;
        display: inline-block;
        width: 40pt;
        padding-right: 15pt;
        img {
          position: absolute;
          top: 2.5pt;
          right: 0;
        }
      }
    }
  }

  .page3 {
    .box {
      position: absolute;
      right: 34.2pt;
      top: 553.9pt;
      width: 290pt;
      height: 189pt;
      background: #f5f5f5;
      border-radius: 12pt;
      display: inline-block;
      padding: 15pt 19pt 0 19pt;
      font-weight: normal;
      .name {
        text-align: center;
        font-size: 16pt;
        line-height: 16pt;
        padding-bottom: 20pt;
      }
      .item {
        padding: 1.5pt 0;
        min-height: 12pt;
        .label {
          color: #605f5f;
        }
        .value {
          color: #000;
        }
      }

      .jzcode {
        position: absolute;
        left: -1pt;
        color: #000;
        bottom: -23pt;
        .label {
          color: #000
        }
      }
    }

    .table-box {
      top: 237pt;
      left: 61pt;
      width: 469pt;
      table {
        td, th {
          padding: 6pt 3pt;
        }
        .label {
          background-color: rgb(244, 251, 253);
          width: 12%;
        }
        .value {
          width: 21%;
          font-weight: normal;
        }
      }
    }
  }

  .page5 {
    .table-box {
      top: 164pt;
      left: 61pt;
      width: 472pt;
      font-size: 10pt;
      table {
        td, th {
          padding: 8pt 3pt;
        }
        .head {
          background-color: rgb(244, 251, 253);
          .head-td1 {
            width: 28%;
          }
          .head-td2 {
            width: 50%;
          }
          .head-td3 {
            width: 10%;
          }
          .head-td4 {
            width: 12%;
          }
        }
        .body {
          font-weight: normal;
          .dot {
            width: 10pt;
          }
        }
      }
    }
  }

  .page6 {

    .level1 {
      background: rgb(148, 197, 102);
    }

    .level2 {
      background: rgb(77, 181, 220);
    }

    .level3 {
      background: rgb(244, 181, 47);
    }

    .level4 {
      background: rgb(215, 55, 51);
    }

    .risk {
      position: absolute;
      width: 6.5pt;
      display: inline-block;
      bottom: 430pt;
    }

    .risk3 {
      left: 113.5pt;
    }

    .risk4 {
      left: 161.5pt;
    }

    .risk5 {
      left: 209.5pt;
    }

    .risk6 {
      left: 257.5pt
    }

    .risk7 {
      left: 305.5pt
    }

    .risk8 {
      left: 353.5pt
    }

    .risk9 {
      left: 401.5pt
    }

    .risk10 {
      left: 449.5pt
    }

    .risk11 {
      left: 497.5pt
    }

    .risk-icon {
      position: absolute;
      display: inline-block;
      bottom: 430pt;
      img {
        width: 20pt;
      }
    }

    .risk-icon3 {
      left: 124.5pt
    }

    .risk-icon4 {
      left: 172.5pt
    }

    .risk-icon5 {
      left: 220.5pt
    }

    .risk-icon6 {
      left: 268.5pt
    }

    .risk-icon7 {
      left: 316.5pt
    }

    .risk-icon8 {
      left: 364.5pt
    }

    .risk-icon9 {
      left: 412.5pt
    }

    .risk-icon10 {
      left: 460.5pt
    }

    .risk-icon11 {
      left: 508.5pt
    }
  }

  .page-7-3-1, .page-7-4-1, .page-7-5-1, .page-7-6-1, .page-7-7-1, .page-7-8-1, .page-7-9-1, .page-7-10-1, .page-7-11-1 {
    .table-box {
      top: 275pt;
      left: 61pt;
      width: 472pt;
      font-size: 10pt;
      table {
        td, th {
          padding: 8pt 3pt;
        }
        .head {
          background-color: rgb(244, 251, 253);
          .head-td1 {
            width: 28%;
          }
          .head-td2 {
            width: 50%;
          }
          .head-td3 {
            width: 10%;
          }
          .head-td4 {
            width: 12%;
          }
        }
        .body {
          font-weight: normal;
          .dot {
            width: 10pt;
          }
        }
      }
    }
  }

  .page-7-3-1 {
    .table-box {
      top: 275pt;
    }
  }

  .page-7-4-1 {
    .table-box {
      top: 295pt;
    }
  }

  .page-7-5-1 {
    .table-box {
      top: 275pt;
    }
  }

  .page-7-6-1 {
    .table-box {
      top: 295pt
    }
  }

  .page-7-7-1 {
    .table-box {
      top: 275pt;
    }
  }

  .page-7-8-1 {
    .table-box {
      top: 275pt;
    }
  }

  .page-7-9-1 {
    .table-box {
      top: 275pt;
    }
  }

  .page-7-10-1 {
    .table-box {
      top: 275pt;
    }
  }

  .page-7-11-1 {
    .table-box {
      top: 275pt;
    }
  }

  .page-7-3-2, .page-7-4-2, .page-7-5-2, .page-7-6-2, .page-7-7-2, .page-7-8-2, .page-7-9-2, .page-7-10-2, .page-7-11-2 {
    .table-box {
      top: 177pt;
      left: 61pt;
      width: 472pt;
      font-size: 10pt;
      table {
        td, th {
          padding: 3pt 3pt;
        }
        .head {
          td, th {
            padding: 7pt 3pt;
          }
          background-color: rgb(244, 251, 253);
          .head-td1 {
            width: 6%;
          }
          .head-td2 {
            width: 31%;
          }
          .head-td3 {
            width: 42%;
          }
          .head-td4 {
            width: 10%;
          }
          .head-td5 {
            width: 11%;
          }
        }
        .body {
          font-weight: normal;
          .dot {
            width: 10pt;
          }
        }
      }
    }
  }

  .page-7-3-3, .page-7-4-3, .page-7-5-3, .page-7-6-3, .page-7-7-3, .page-7-8-3, .page-7-9-3, .page-7-10-3, .page-7-11-3 {
    .table-box {
      top: 177pt;
      left: 61pt;
      width: 472pt;
      font-size: 10pt;
      table {
        td, th {
          padding: 3pt 3pt;
        }
        .head {
          td, th {
            padding: 7pt 3pt;
          }
          background-color: rgb(244, 251, 253);
          .head-td1 {
            width: 10%;
          }
          .head-td2 {
            width: 50%;
          }
          .head-td3 {
            width: 20%;
          }
          .head-td4 {
            width: 20%;
          }
        }
        .body {
          font-weight: normal;
          .dot {
            width: 10pt;
          }
        }
      }
    }
  }

  .page-7-3-4, .page-7-4-4, .page-7-5-4, .page-7-6-4, .page-7-7-4, .page-7-8-4, .page-7-9-4, .page-7-10-4, .page-7-11-4 {
    .table-box {
      top: 177pt;
      left: 61pt;
      width: 472pt;
      font-size: 10pt;
      table {
        td, th {
          padding: 3pt 3pt;
        }
        .head {
          td, th {
            padding: 7pt 3pt;
          }
          background-color: rgb(244, 251, 253);
          .head-td1 {
            width: 8%;
          }
          .head-td2 {
            width: 26%;
          }
          .head-td3 {
            width: 50%;
          }
          .head-td4 {
            width: 16%;
          }
        }
        .body {
          font-weight: normal;
          .dot {
            width: 10pt;
          }
          .body-td4 {
            /*text-align: right;*/
            /*padding-right: 10pt;*/
          }
        }
      }
    }
  }
</style>
