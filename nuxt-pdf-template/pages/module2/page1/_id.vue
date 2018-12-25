<template>
  <div class="book">
    <div class="page">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page1/1.png">
      <div style="position: absolute;top:5pt;left: 5pt;font-size: 20pt;color: red;">{{data.id}}</div>
    </div>

    <div class="page">
      &nbsp;
    </div>

    <div class="page page3">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page1/3.png">
      <div class="right-page">
        <img src="~/assets/module2/page1/right-page.png">
        <div>1/{{data.pageNoSize}}</div>
      </div>
      <div class="created-date">
        建议书生成日期：{{data.createdTime | formatDate("yyyy年MM月dd日")}}
      </div>
      <div class="box">
        <div class="name">{{data.name}}(参数ID：{{data.id}})</div>
        <div class="item">
          <span class="label">联系电话：</span>{{data.mobile}}
        </div>
        <div class="item">
          <span class="label">套餐名称：</span>{{data.packageGroupName}}
        </div>
        <div class="item">
        </div>
        <div class="item" v-if="data.diseaseType === 'GENE_SUBHEALTH' || data.diseaseType === 'GENE'">
          <span class="label">遗传检测编码：</span>{{data.geneCode}}
        </div>
        <div class="item" v-if="data.diseaseType === 'GENE_SUBHEALTH' || data.diseaseType === 'SUBHEALTH'">
          <span class="label">亚健康检测编码：</span>{{data.subhealthCode}}
        </div>
        <div class="item">
          <span class="label">客 户 经 理：</span>{{data.salesName}}
        </div>
        <div class="item">
          <span class="label">公 司 名 称：</span>{{data.companyName}}
        </div>
        <div class="jzcode item">
          <span class="label">精准体检检测编码：</span>{{data.jzcode}}
        </div>
      </div>
    </div>

    <div class="page">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page1/4.png">
      <div class="left-page">
        <img src="~/assets/module2/page1/left-page.png">
        <div>2/{{data.pageNoSize}}</div>
      </div>
    </div>

    <div class="page page5">
      &nbsp;
      <img v-if="data.diseaseType === 'GENE_SUBHEALTH'" class="page-img"
           src="~/assets/module2/page1/5-1.png">
      <img v-if="data.diseaseType === 'GENE'" class="page-img"
           src="~/assets/module2/page1/5-2.png">
      <img v-if="data.diseaseType === 'SUBHEALTH'" class="page-img"
           src="~/assets/module2/page1/5-3.png">


      <div class="right-page">
        <img src="~/assets/module2/page1/right-page.png">
        <div>3/{{data.pageNoSize}}</div>
      </div>

      <div v-if="data.diseaseType === 'GENE_SUBHEALTH' || data.diseaseType === 'GENE'">
        <div class="gene-risk-box1 box" v-if="data.geneRisk1.length > 0">
          <div class="item" v-for="(item, index) in data.geneRisk1">
            <div class="dot-box">
              <img src="~/assets/module2/page1/dot.png">
              <span class="dot-number">{{index + 1}}</span>
            </div>
            <span class="text">{{item}}</span>
          </div>
        </div>
        <div class="gene-risk-box2 box" v-if="data.geneRisk2.length > 0">
          <div class="item" v-for="(item, index) in data.geneRisk2">
            <div class="dot-box">
              <img src="~/assets/module2/page1/dot.png">
              <span class="dot-number">{{index + 6}}</span>
            </div>
            <span class="text">{{item}}</span>
          </div>
        </div>
        <div class="none gene-risk-none" v-if="data.geneRisk1.length === 0">
          根据检测结果显示，您的相关遗传疾病风险较低
        </div>
      </div>
      <div v-if="data.diseaseType === 'GENE_SUBHEALTH' || data.diseaseType === 'SUBHEALTH'">
        <div class="subhealth-box1 box" v-if="data.subhealthRisk1.length > 0">
          <div class="item" v-for="(item, index) in data.subhealthRisk1">
            <div class="dot-box">
              <img src="~/assets/module2/page1/dot.png">
              <span class="dot-number">{{index + 1}}</span>
            </div>
            <span class="text">{{item}}</span>
          </div>
        </div>
        <div class="subhealth-box2 box" v-if="data.subhealthRisk2.length > 0">
          <div class="item" v-for="(item, index) in data.subhealthRisk2">
            <div class="dot-box">
              <img src="~/assets/module2/page1/dot.png">
              <div class="dot-number">{{index + 6}}</div>
            </div>
            <span class="text">{{item}}</span>
          </div>
        </div>
        <div class="none subhealth-none" v-if="data.subhealthRisk1.length === 0">
          根据检测结果显示，您的相关亚健康疾病风险较低
        </div>
      </div>
    </div>

    <div class="page">
      &nbsp;
      <img v-if="data.pkgExamType === 'male-a'" class="page-img"
           src="~/assets/module2/page1/6-male-a.png">
      <img v-if="data.pkgExamType === 'male-b'" class="page-img"
           src="~/assets/module2/page1/6-male-b.png">
      <img v-if="data.pkgExamType === 'male-c'" class="page-img"
           src="~/assets/module2/page1/6-male-c.png">
      <img v-if="data.pkgExamType === 'male-d'" class="page-img"
           src="~/assets/module2/page1/6-male-d.png">

      <img v-if="data.pkgExamType === 'female-married-a'" class="page-img"
           src="~/assets/module2/page1/6-female-married-a.png">
      <img v-if="data.pkgExamType === 'female-married-b'" class="page-img"
           src="~/assets/module2/page1/6-female-married-b.png">
      <img v-if="data.pkgExamType === 'female-married-c'" class="page-img"
           src="~/assets/module2/page1/6-female-married-c.png">
      <img v-if="data.pkgExamType === 'female-married-d'" class="page-img"
           src="~/assets/module2/page1/6-female-married-d.png">

      <img v-if="data.pkgExamType === 'female-unmarried-a'" class="page-img"
           src="~/assets/module2/page1/6-female-unmarried-a.png">
      <img v-if="data.pkgExamType === 'female-unmarried-b'" class="page-img"
           src="~/assets/module2/page1/6-female-unmarried-b.png">
      <img v-if="data.pkgExamType === 'female-unmarried-c'" class="page-img"
           src="~/assets/module2/page1/6-female-unmarried-c.png">
      <img v-if="data.pkgExamType === 'female-unmarried-d'" class="page-img"
           src="~/assets/module2/page1/6-female-unmarried-d.png">

      <div class="left-page">
        <img src="~/assets/module2/page1/left-page.png">
        <div>4/{{data.pageNoSize}}</div>
      </div>
    </div>

    <div class="page page7" v-for="(jzexamAdvicePrjGroupVoList,index) of data.jzexamAdvicePrjGroupVoListGroup">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page1/7.png">
      <div v-if="(index + 1) % 2 !== 0" class="right-page">
        <img src="~/assets/module2/page1/right-page.png">
        <div>{{5 + index}}/{{data.pageNoSize}}</div>
      </div>
      <div v-if="(index + 1) % 2 === 0" class="left-page">
        <img src="~/assets/module2/page1/left-page.png">
        <div>{{5 + index}}/{{data.pageNoSize}}</div>
      </div>
      <div class="table-box">
        <table>
          <tbody>
          <tr class="head-tr">
            <td class="head-td1">项目分类</td>
            <td class="head-td2">检查内容</td>
          </tr>
          <tr v-for="item in jzexamAdvicePrjGroupVoList">
            <td>
              <div class="body-td1-box" v-html="item.hcitemCategory2"></div>
            </td>
            <td>
              <div class="body-td2-box" v-html="item.hcitemName"></div>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>

    <div class="page" v-if="data.pageNoSize % 2 === 0">
      &nbsp;
    </div>

    <div class="page">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page1/8.png">
      <div class="right-page">
        <img src="~/assets/module2/page1/right-page.png">
        <div>{{data.pageNoSize - 2}}/{{data.pageNoSize}}</div>
      </div>
    </div>

    <div class="page">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page1/9.png">
      <div class="left-page">
        <img src="~/assets/module2/page1/left-page.png">
        <div>{{data.pageNoSize - 1}}/{{data.pageNoSize}}</div>
      </div>
    </div>

    <div class="page">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page1/10.png">
      <div class="right-page">
        <img src="~/assets/module2/page1/right-page.png">
        <div>{{data.pageNoSize}}/{{data.pageNoSize}}</div>
      </div>
    </div>

    <div class="page">
      &nbsp;
      <img class="page-img" src="~/assets/module2/page1/12.png">
    </div>
  </div>
</template>

<script>
  import {mapState} from "vuex"

  export default {
    async fetch({store, route}) {
      await store.dispatch('module2-page1/GET_DATA', route.params.id);
    },
    computed: {
      ...mapState('module2-page1', {
        data: state => state.data
      })
    },

  }
</script>
<style scoped lang="less">

  .left-page, .right-page {
    position: absolute;
    top: 353pt;
    width: 35pt;
    img {
      width: 35pt;
    }
    div {
      position: absolute;
      top: 36pt;
      width: 34pt;
      text-align: center;
      display: inline-block;
      font-weight: normal;
      font-size: 13pt;
      letter-spacing: -1pt;
    }
  }

  .left-page {
    left: 0;
  }
  .right-page {
    right: 0;
  }

  .page3 {
    .created-date {
      position: absolute;
      top: 379pt;
      width: 100%;
      text-align: center;
      font-size: 12pt;
    }
    .box {
      position: absolute;
      right: 34.2pt;
      top: 552.9pt;
      width: 290pt;
      height: 189pt;
      background: #f5f5f5;
      border-radius: 12pt;
      display: inline-block;
      padding: 8pt 19pt 0 19pt;
      .name {
        text-align: center;
        font-size: 16pt;
        line-height: 16pt;
        padding-bottom: 14pt;
      }
      .jzcode {
        position: absolute;
        left: 19pt;
        bottom: -23pt;
      }
      .item {
        color: #605f5f;
        padding: 1.5pt 0;
        min-height: 12pt;
        .label {
          color: #a4a4a4;
        }
      }
    }
  }

  .page5 {
    .box {
      position: absolute;
      width: 200pt;
      .item {
        position: relative;
        padding-bottom: 4pt;
        .dot-box {
          display: inline-block;
          position: relative;
          img {
            width: 25pt;
          }
          .dot-number {
            position: absolute;
            left: -2pt;
            display: inline-block;
            text-align: center;
            width: 23pt;
            top: 1pt;
            color: #fff;
            font-size: 14pt;
          }
        }
        .text {
          position: absolute;
          display: inline-block;
          top: 0;
          left: 27pt;
          font-size: 14pt;
          line-height: 14pt;
          font-weight: normal;
          color: #474747;
        }
      }
    }
    .gene-risk-box1 {
      top: 215pt;
      left: 69pt;
    }

    .gene-risk-box2 {
      top: 215pt;
      left: 318pt;
    }

    .subhealth-box1 {
      top: 468pt;
      left: 69pt;
    }

    .subhealth-box2 {
      top: 468pt;
      left: 318pt;
    }

    .none {
      position: absolute;
      text-align: center;
      font-size: 16pt;
      height: 195pt;
      width: 100%;
      line-height: 195pt;
    }

    .gene-risk-none {
      top: 199pt;
    }

    .subhealth-none {
      top: 450pt;
    }
  }

  .page7 {
    .table-box {
      position: absolute;
      top: 122pt;
      left: 66pt;
      width: 483pt;
      table {
        width: 100%;
        .head-tr {
          font-size: 14pt;
          line-height: 14pt;
          text-align: center;
        }
        .head-td1 {
          width: 164pt;
        }
        .head-td2 {
          width: 319pt;
        }
        td {
          padding: 3pt 2pt;
        }
        .body-td1-box {
          width: 158pt;
          display: inline-block;
          text-align: center;
          white-space: nowrap;
        }
        .body-td2-box {
          width: 313pt;
          display: inline-block;
          white-space: nowrap;
        }
      }
    }
  }
</style>
