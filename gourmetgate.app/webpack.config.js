const baseConfig = require('@eclipse-scout/cli/scripts/webpack-defaults');

module.exports = (env, args) => {
  args.resDirArray = ['src/main/resources/WebContent', 'node_modules/@eclipse-scout/core/res'];
  const config = baseConfig(env, args);

  config.entry = {
    'gourmetgate': './src/main/js/gourmetgate.ts',
    'gourmetgate-theme': './src/main/js/gourmetgate-theme.less',
    'gourmetgate-theme-dark': './src/main/js/gourmetgate-theme-dark.less'
  };

  return config;
};
