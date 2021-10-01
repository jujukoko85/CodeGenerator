<#assign entityType = entity.camelBigName() />
<#assign entityName = entity.camelSmallName() />
<#assign entityLineName = entity.lineName() />
<#assign primaryName = entity.primary().camelSmallName() />
${r'<#assign pageHeadStyles>'}
    ${r'<link type="text/css" rel="stylesheet" href="${appConfig.stylesUrl}/css/bootstrap-datetimepicker.min.css" />'}
${r'</#assign>'}
${r'<#include "../../../common/page_header.ftl" />'}
${r'<#include "../../../common/common_header.ftl" />'}

${r'<#assign '}pageTitle="${entityType}列表" />
${r'<#assign '}listAction="/${entityLineName}/${entityLineName}_list" />
${r'<#assign '}editAction="/${entityLineName}/${entityLineName}_edit" />
${r'<#assign '}deleteAction="/${entityLineName}/${entityLineName}_delete" />
${r'<#assign '}firstPageUrl=listAction />

<div class="container-fluid">
    <div class="row">
        <nav class="col">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/">首页</a></li>
                <li class="breadcrumb-item active" aria-current="page">${r'${pageTitle}'}</li>
            </ol>
        </nav>
    </div>
    <div class="row">
        <form class="form-inline" action="${r'${listAction}'}" method="post" id="pageForm">
            <div class="form-group mr-1 mb-1">
                <a href="${r'${editAction}'}" class="btn btn-info">新增</a>
            </div>
            <div class="form-group mr-1 mb-1">
                <button type="submit" class="btn btn-primary">查 询</button>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="table-responsive">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>操作</th>
                    <#list entity.properties as property>
                        <#if !property.primary>
                    <th>${property.comment}</th>
                        </#if>
                    </#list>
                </tr>
                </thead>
                <tbody>
                ${r'<#if (page?? && page.recordList??)>'}
                    ${r'<#list page.recordList as entity>'}
                        ${r'<tr id="tr_entity_${entity.id}">'}
                            ${r'<td>${(page.currentPage - 1)*(page.numPerPage)+(entity_index+1)}<input type="hidden" id="txt_entity_id_${entity_index}"'} name="${primaryName}" ${r'value="${entity.id}" /></td>'}
                            <td>
                                ${r'<a href="${editAction}?id=${entity.id}" target="_blank" title="修改"><i class="bi-pencil"></i></a>'}
                                &nbsp;
                                ${r'<a href="javascript:void(0)" data-id="${entity.id}" data-action="${deleteAction}" data-confirm="是否删除?" onclick="return Page.showConfirmModal(this);" title="删除"><span class="glyphicon glyphicon-trash"></span></a>'}
                            </td>
                            <#list entity.properties as property>
                                <#if !property.primary>
                            <td>${r'${entity.'}${property.camelSmallName()}${r'}'}</td>
                                </#if>
                            </#list>
                        </tr>
                    ${r'</#list>'}
                     ${r'<#if page.recordList?size < pageSize>'}
                         ${r'<#list 1..(pageSize - page.recordList?size) as idx>'}
                            <tr>
                                 ${r'<td>${idx + page.totalCount}</td>'}
                                <td></td>
                                <#list entity.properties as property>
                                    <#if !property.primary>
                                <td></td>
                                    </#if>
                                </#list>
                            </tr>
                        ${r'</#list>'}
                    ${r'</#if>'}
                ${r'</#if>'}<#-- // end if page.content?size -->
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        ${r'<@global.pageable currPage=page.currentPage pageCount=page.totalPage showPages=5 totalCount=page.totalCount urlPattern="${listAction}?currentPage={p}" />'}
    </div>
</div>

${r'<#include "../../../common/dialog_confirm.ftl" />'}

${r'<#assign pageFootScripts>'}
    ${r'<script type="text/javascript" src="${appConfig.scriptsUrl}/js/dialog_confirm.js"></script>'}
    ${r'<script type="text/javascript" src="${appConfig.scriptsUrl}/js/page.js"></script>'}

    ${r'<script type="text/javascript" src="${appConfig.scriptsUrl}/js/bootstrap-datetimepicker.min.js"></script>'}
    ${r'<script type="text/javascript" src="${appConfig.scriptsUrl}/js/bootstrap-datetimepicker.zh-CN.js"></script>'}
    ${r'<script type="text/javascript" src="${appConfig.scriptsUrl}/js/bootstrap-datetimepicker-format.js"></script>'}
${r'</#assign>'}


${r'<#include "../../../common/common_footer.ftl" />'}
${r'<#include "../../../common/page_footer.ftl" />'}
<!--blank line-->