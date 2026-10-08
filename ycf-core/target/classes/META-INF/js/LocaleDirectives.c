#include <stdio.h>
#include <stddef.h>
#include <memory.h>

#include "/opt/graalvm-community-25.2.4+7.1/lib/svm/clibraries/include/svm_locale.h"

int LocaleDirectives() {
    printf("NativeCodeInfo:LocaleDirectives:ConstantInfo:SVM_LOCALE_INITIALIZATION_OUT_OF_MEMORY:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(SVM_LOCALE_INITIALIZATION_OUT_OF_MEMORY)));
    printf("NativeCodeInfo:LocaleDirectives:ConstantInfo:SVM_LOCALE_INITIALIZATION_OUT_OF_MEMORY:PropertyInfo:signedness=$%s$\n", ((SVM_LOCALE_INITIALIZATION_OUT_OF_MEMORY>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:LocaleDirectives:ConstantInfo:SVM_LOCALE_INITIALIZATION_OUT_OF_MEMORY:PropertyInfo:value=%lX\n", ((unsigned long)SVM_LOCALE_INITIALIZATION_OUT_OF_MEMORY));
    printf("NativeCodeInfo:LocaleDirectives:ConstantInfo:SVM_LOCALE_INITIALIZATION_SUCCEEDED:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(SVM_LOCALE_INITIALIZATION_SUCCEEDED)));
    printf("NativeCodeInfo:LocaleDirectives:ConstantInfo:SVM_LOCALE_INITIALIZATION_SUCCEEDED:PropertyInfo:signedness=$%s$\n", ((SVM_LOCALE_INITIALIZATION_SUCCEEDED>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:LocaleDirectives:ConstantInfo:SVM_LOCALE_INITIALIZATION_SUCCEEDED:PropertyInfo:value=%lX\n", ((unsigned long)SVM_LOCALE_INITIALIZATION_SUCCEEDED));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(svm_locale_props_t)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:display_country:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_locale_props_t *) 0)->display_country)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:display_country:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_locale_props_t, display_country)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:display_language:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_locale_props_t *) 0)->display_language)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:display_language:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_locale_props_t, display_language)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:display_script:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_locale_props_t *) 0)->display_script)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:display_script:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_locale_props_t, display_script)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:display_variant:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_locale_props_t *) 0)->display_variant)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:display_variant:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_locale_props_t, display_variant)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:format_country:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_locale_props_t *) 0)->format_country)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:format_country:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_locale_props_t, format_country)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:format_language:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_locale_props_t *) 0)->format_language)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:format_language:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_locale_props_t, format_language)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:format_script:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_locale_props_t *) 0)->format_script)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:format_script:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_locale_props_t, format_script)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:format_variant:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((svm_locale_props_t *) 0)->format_variant)));
    printf("NativeCodeInfo:LocaleDirectives:StructInfo:svm_locale_props_t:StructFieldInfo:format_variant:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(svm_locale_props_t, format_variant)));
    return 0;
}

int main(void) {
    return LocaleDirectives();
}
