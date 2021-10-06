<#assign entityType = entity.camelBigName() />
<#assign entityName = entity.camelSmallName() />
<#assign entityLineName = entity.lineName() />
<#assign primaryName = entity.primary().camelSmallName() />

${r'<#assign pageHeadStyles>'}
    ${r'<link type="text/css" rel="stylesheet" href="${appConfig.stylesUrl}/css/bootstrap-datetimepicker.min.css" />'}
${'</#assign>'}

${'<#include "../../../common/page_header.ftl" />'}
${'<#include "../../../common/common_header.ftl" />'}

${r'<#assign'} pageTitleAdd="${entityType}新增" />
${r'<#assign'} pageTitleUpd="${entityType}更新" />
${r'<#assign'} listAction="/${entityLineName}/${entityLineName}_list" />
${r'<#assign'} saveAction="/${entityLineName}/${entityLineName}_save" />
${r'<#assign'} updateAction="/${entityLineName}/${entityLineName}_update" />

${r'<input id="dialog-success-btn-ok-url" type="hidden" value="${listAction}" />'}

<div class="container-fluid">
    <div class="row">
        <nav class="col">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/">首页</a></li>
                ${r'<li class="breadcrumb-item active" aria-current="page"><#if entity??>${pageTitleUpd}<#else>${pageTitleAdd}</#if></li>'}
            </ol>
        </nav>
    </div>
    <div class="row">
        ${r'<form class="form_edit col submit-confirm repeat-submit" action="<#if entity??>${updateAction}<#else>${saveAction}</#if>" method="post">'}
            <input type="hidden" name="${primaryName}" ${r'value="<#if entity??>${entity.id}</#if>" />'}
            <#list entity.properties as property>
                <#if !property.primary>
            <div class="form-group row">
                <label class="col-md-1 col-form-label submit-confirm-name">${property.comment}</label>
                <div class="col-md-3">
                    <input type="text" class="form-control submit-confirm-value" name="${property.camelSmallName()}" value="${r'<#if entity??>${entity.'}${property.camelSmallName()}${r'}<#else></#if>'}">
                </div>
            </div>
                </#if>
            </#list>
            <div class="form-group row">
                <div class="col-md-6">
                    <button type="reset" class="btn btn-light" onclick="window.history.back();">返  回</button>
                    &nbsp;
                    <button type="reset" class="btn btn-info">重  填</button>
                    &nbsp;
                    <a href="javascript:void(0)" class="btn btn-primary" data-confirm="" onclick="return PageConfirm.showSubmitConfirmModal(this, $(this).parents('form'));">${r'<#if entity??>更  新<#else>保  存</#if></a>'}
                </div>
            </div>
        </form>
    </div>
</div>

${r'<#include "../../../common/dialog_message.ftl" />'}
${r'<#include "../../../common/submit_form_confirm.ftl" />'}

${r'<#assign pageFootScripts>'}
    ${r'<script type="text/javascript" src="${appConfig.scriptsUrl}/js/dialog_message.js"></script>'}
    ${r'<script type="text/javascript" src="${appConfig.scriptsUrl}/js/repeat-submit.js"></script><!-- 防止重复提交 -->'}
    ${r'<script type="text/javascript" src="${appConfig.scriptsUrl}/js/submit_form_confirm.js"></script>'}

    ${r'<script type="text/javascript" src="${appConfig.scriptsUrl}/js/bootstrap-datetimepicker.min.js"></script>'}
    ${r'<script type="text/javascript" src="${appConfig.scriptsUrl}/js/bootstrap-datetimepicker.zh-CN.js"></script>'}
    ${r'<script type="text/javascript" src="${appConfig.scriptsUrl}/js/bootstrap-datetimepicker-format.js"></script>'}
${r'</#assign>'}

${r'<#include "../../../common/common_footer.ftl" />'}
${r'<#include "../../../common/page_footer.ftl" />'}